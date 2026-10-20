import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceTest {

    @Test
    void addingStudentIncreasesCount() {
        StudentService service = new StudentService();

        service.addStudent("Harshit");

        assertEquals(1, service.getStudentCount());
    }

    @Test
    void addingTwoStudentsIncreasesCountByTwo() {
        StudentService service = new StudentService();

        service.addStudent("Harshit");
        service.addStudent("Rahul");

        assertEquals(2, service.getStudentCount());
    }

    @Test
    void invalidActionThrowsException() {
        StudentService service = new StudentService();

        assertThrows(
            IllegalArgumentException.class,
            () -> service.performAction("delete")
        );
    }
}