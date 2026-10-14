public class MiniBank {

    public static void main(String[] args) {

        Account[] accounts = {
            new Account("Harshit", 5000),
            new Account("Rahul"),
            new Account("Aman", 10000)
        };

        accounts[0].deposit(2000);
        accounts[1].deposit(5000);
        accounts[2].deposit(3000);

        boolean result1 = accounts[0].withdraw(1000);
        boolean result2 = accounts[1].withdraw(2000);
        boolean result3 = accounts[2].withdraw(15000);

        System.out.println("Withdrawal 1 successful: " + result1);
        System.out.println("Withdrawal 2 successful: " + result2);
        System.out.println("Withdrawal 3 successful: " + result3);

        System.out.println("\n----- Account Details -----");
        for (Account account : accounts) {
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Owner: " + account.getOwnerName());
            System.out.println("Balance: ₹" + account.getBalance());
            System.out.println("Active: " + account.isActive());
            System.out.println();
        }
    }
}