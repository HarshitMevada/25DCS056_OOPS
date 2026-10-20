import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class BankServiceTest {
    @TempDir
    Path tempDir;

    private Repository<Account> repository;
    private BankService service;
    private TransactionProcessor processor;

    @BeforeEach
    void setUp() {
        repository = new Repository<>();
        processor = new TransactionProcessor();
        repository.save(new SavingsAccount("Test User", 1000, 0));
        service = new BankService(repository, processor, tempDir.resolve("transactions.log"));
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        service.shutdown();
    }

    @Test
    void depositIncreasesBalance() throws BankException {
        Account account = service.listAccounts().get(0);
        long original = account.getBalance();
        service.deposit(account.getAccountNumber(), 250);
        assertEquals(original + 250, account.getBalance());
    }

    @Test
    void withdrawalOverAvailableBalanceThrowsException() {
        Account account = service.listAccounts().get(0);
        assertThrows(InsufficientFundsException.class,
                () -> service.withdraw(account.getAccountNumber(), 1001));
    }

    @Test
    void concurrentDepositsKeepCorrectBalance() throws Exception {
        Account account = service.listAccounts().get(0);
        int workers = 20;
        int depositsPerWorker = 100;
        long amount = 5;
        ExecutorService pool = Executors.newFixedThreadPool(workers);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(workers);
        List<Throwable> errors = java.util.Collections.synchronizedList(new ArrayList<>());
        long original = account.getBalance();

        for (int i = 0; i < workers; i++) {
            pool.submit(() -> {
                try {
                    start.await();
                    for (int j = 0; j < depositsPerWorker; j++) {
                        service.deposit(account.getAccountNumber(), amount);
                    }
                } catch (Throwable e) {
                    errors.add(e);
                } finally {
                    done.countDown();
                }
            });
        }
        start.countDown();
        done.await(30, TimeUnit.SECONDS);
        pool.shutdown();
        pool.awaitTermination(30, TimeUnit.SECONDS);

        assertEquals(List.of(), errors);
        assertEquals(original + (long) workers * depositsPerWorker * amount,
                account.getBalance());
    }
}
