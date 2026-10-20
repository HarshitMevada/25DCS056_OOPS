import java.util.ArrayList;

public class StudentService {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Student name cannot be empty"
            );
        }

        Student student = new Student(students.size() + 1, name);
        students.add(student);
    }

    public int getStudentCount() {
        return students.size();
    }

    public void showStudents() {
        for (Student student : students) {
            System.out.println(
                student.getId() + ". " + student.getName()
            );
        }
    }

    public void performAction(String action) {
        switch (action.toLowerCase()) {
            case "add":
                System.out.println("Use addStudent() to add a student.");
                break;

            case "list":
                showStudents();
                break;

            case "count":
                System.out.println("Total students: " + getStudentCount());
                break;

            default:
                throw new IllegalArgumentException(
                    "Invalid action: " + action
                );
        }
    }
}