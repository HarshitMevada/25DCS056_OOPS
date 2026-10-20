import java.util.*;

public class p12_partA_1 {
    public static void main(String[] args) {
        String paragraph = "java is easy java is powerful java is popular";

        HashMap<String, Integer> map = new HashMap<>();

        String[] words = paragraph.toLowerCase().split("\\s+");

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list =
            new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> a,
                               Map.Entry<String, Integer> b) {
                return b.getValue().compareTo(a.getValue());
            }
        });
        System.out.println("Word Frequencies:");

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
