import java.nio.file.*;
import java.io.IOException;
import java.util.List;

public class p11_partA_2 {
    public static void main(String[] args) {
        String[] fileNames = {
            "log1.txt",
            "log2.txt",
            "log3.txt"
        };

        String keyword = "ERROR";
        int totalLines = 0;
        int matchingLines = 0;

        try {
            for (String fileName : fileNames) {
                Path path = Paths.get(fileName);

                if (Files.notExists(path)) {
                    if (fileName.equals("log1.txt")) {
                        Files.write(path, List.of(
                            "Application started",
                            "ERROR: File not found",
                            "Application closed"
                        ));
                    } else if (fileName.equals("log2.txt")) {
                        Files.write(path, List.of(
                            "User logged in",
                            "ERROR: Connection failed"
                        ));
                    } else {
                        Files.write(path, List.of(
                            "System running normally",
                            "User logged out"
                        ));
                    }
                }

                int fileLines = 0;
                int fileMatches = 0;

                try (var reader = Files.newBufferedReader(path)) {
                    String line;

                    while ((line = reader.readLine()) != null) {
                        fileLines++;

                        if (line.contains(keyword)) {
                            fileMatches++;
                        }
                    }
                }
                totalLines += fileLines;
                matchingLines += fileMatches;

                long size = Files.size(path);

                System.out.println("File: " + fileName);
                System.out.println("Size: " + size + " bytes");
                System.out.println("Lines: " + fileLines);
                System.out.println("Matching lines: " + fileMatches);
                System.out.println();
            }
            System.out.println("Total lines: " + totalLines);
            System.out.println("Total matching lines: " + matchingLines);
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
