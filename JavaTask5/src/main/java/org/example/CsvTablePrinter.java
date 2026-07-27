package org.example;
import java.util.*;

public class CsvTablePrinter {
    public static void main(String[] args) {
        // Step 2: Store CSV rows
        List<String> rows = Arrays.asList(
                "Name,Age,City",
                "Ali,25,Muscat",
                "Sara,30,Nizwa",
                "Hassan,70,Sohar",
                "Mona,15,Salalah",
                "BadRow,OnlyTwoFields" // malformed row
        );

        // Step 3: Split header
        String[] header = rows.get(0).split(",");

        // Step 5: Print header
        for (String h : header) {
            System.out.print(h + "\t"); // print each title with a tab
        }
        System.out.println();

        // Separator line
        System.out.println("-----------------------------");

        // Step 4 + 5: Print data rows
        int shownCount = 0;
        for (int i = 1; i < rows.size(); i++) {
            String[] fields = rows.get(i).split(",");
            if (fields.length == header.length) {
                for (String f : fields) {
                    System.out.print(f.trim() + "\t"); // print each field with a tab
                }
                System.out.println();
                shownCount++;
            } else {
                System.out.println("Skipping  row: " + rows.get(i));
            }
        }

        // Step 6: Print how many rows were shown
        System.out.println("\nData rows shown: " + shownCount);
    }
}
