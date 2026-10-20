import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. Show Students");
            System.out.println("3. Show Count");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter student name: ");
                        String name = sc.nextLine();
                        service.addStudent(name);
                        System.out.println("Student added successfully.");
                        break;

                    case 2:
                        service.performAction("list");
                        break;

                    case 3:
                        service.performAction("count");
                        break;

                    case 4:
                        System.out.println("Exiting...");
                        sc.close();
                        return;

                    default:
                        service.performAction("invalid");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}