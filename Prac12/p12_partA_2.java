import java.util.*;

public class p12_partA_2 {
    public static void main(String[] args) {
        String[] logins = {
            "Harshit", "Rahul", "Priya", "Harshit",
            "Amit", "Rahul", "Neha", "Priya"
        };

        HashSet<String> uniqueUsers = new HashSet<>();

        LinkedHashSet<String> orderedUsers = new LinkedHashSet<>();

        for (String name : logins) {
            uniqueUsers.add(name);
            orderedUsers.add(name);
        }

        System.out.println("Unique user count: " + uniqueUsers.size());

        System.out.println("First three distinct users:");

        int count = 0;

        for (String name : orderedUsers) {
            if (count == 3) {
                break;
            }
            System.out.println(name);
            count++;
        }
    }
}
