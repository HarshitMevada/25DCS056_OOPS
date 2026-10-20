import java.io.*;

class Student implements Serializable {
    int id;
    String name;
    transient String password;

    Student(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Password: " + password);
        System.out.println();
    }
}

public class p11_partA_1 {
    public static void main(String[] args) {
        Student[] students = {
            new Student(1, "Harshit", "abc123"),
            new Student(2, "Rahul", "xyz456")
        };

        try (ObjectOutputStream out =
                 new ObjectOutputStream(
                     new FileOutputStream("students.dat"))) {

            out.writeObject(students);
            System.out.println("Objects saved successfully.");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        try (ObjectInputStream in =
                 new ObjectInputStream(
                     new FileInputStream("students.dat"))) {

            Student[] loadedStudents = (Student[]) in.readObject();

            System.out.println("\nLoaded student details:");

            for (Student s : loadedStudents) {
                s.display();
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
