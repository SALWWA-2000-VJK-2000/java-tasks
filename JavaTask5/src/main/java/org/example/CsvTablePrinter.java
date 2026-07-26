package org.example;
import java.util.*;

public class CsvTablePrinter {
     static void main(String[] args) {
        //  2: Store CSV rows
        List<String> rows = Arrays.asList(
                "Name,Age,City",
                "Ali,25,Muscat",
                "Sara,30,Nizwa",
                "Hassan,70,Sohar",
                "Mona,15,Salalah",
                "grtery,ttt"
        );

        //  3: Split header
        String[] header = rows.get(0).split(",");
        int columnCount = header.length;

        //  5: Calculate column widths
        int[] widths = new int[columnCount];
        for (int i = 0; i < columnCount; i++) {
            widths[i] = header[i].length();
        }

        // Adjust widths based on data rows
        for (int i = 1; i < rows.size(); i++) {
            String[] fields = rows.get(i).split(",");
            if (fields.length == columnCount) {
                for (int j = 0; j < columnCount; j++) {
                    widths[j] = Math.max(widths[j], fields[j].trim().length());
                }
            } else {
                System.out.println("Skipping  row: " + rows.get(i));
            }
        }

        //  5: Print header
        for (int i = 0; i < columnCount; i++) {
            System.out.printf("%-" + widths[i] + "s ", header[i]);
        }
        System.out.println();

        // Separator line
        int totalWidth = Arrays.stream(widths).sum() + columnCount;
        System.out.println("-".repeat(totalWidth));

        //  4 + 5: Print rows
        int shownCount = 0;
        for (int i = 1; i < rows.size(); i++) {
            String[] fields = rows.get(i).split(",");
            if (fields.length == columnCount) {
                for (int j = 0; j < columnCount; j++) {
                    System.out.printf("%-" + widths[j] + "s ", fields[j].trim());
                }
                System.out.println();
                shownCount++;
            } else {
                System.out.println("Skipping malformed row: " + rows.get(i));
            }
        }

        //  6: Print count
        System.out.println("\nData rows shown: " + shownCount);
    }
}
