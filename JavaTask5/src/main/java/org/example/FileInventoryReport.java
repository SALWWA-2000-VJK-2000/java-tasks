package org.example;
import java.util.*;

public class FileInventoryReport {
     static void main(String[] args) {
        //  2: Store CSV records
        List<String> records = Arrays.asList(
                "photo.png,340",
                "app.java,8",
                "song.mp3,5120",
                "report.pdf,120",
                "notes.txt,45",
                "archive.zip,2000",
                "fdsfgsge"
        );

        //  3: Counters and totals
        int totalSize = 0;
        int documentCount = 0, imageCount = 0, audioCount = 0, codeCount = 0, otherCount = 0;
        String largestFileName = "";
        int largestFileSize = -1;

        //  4: Loop through records
        for (String record : records) {
            String[] parts = record.split(",");

            if (parts.length == 2) {
                String fileName = parts[0].trim();
                String sizeText = parts[1].trim();
                int size = Integer.parseInt(sizeText);

                //  5: Get extension and classify
                String extension = "none";
                int dotIndex = fileName.lastIndexOf('.');
                if (dotIndex >= 0 && dotIndex < fileName.length() - 1) {
                    extension = fileName.substring(dotIndex + 1).toLowerCase();
                }

                String type;
                if (extension.equals("txt") || extension.equals("pdf") || extension.equals("docx") || extension.equals("xlsx")) {
                    type = "Document";
                    documentCount++;
                } else if (extension.equals("jpg") || extension.equals("png") || extension.equals("gif")) {
                    type = "Image";
                    imageCount++;
                } else if (extension.equals("mp3") || extension.equals("wav")) {
                    type = "Audio";
                    audioCount++;
                } else if (extension.equals("java") || extension.equals("py") || extension.equals("js")) {
                    type = "Code";
                    codeCount++;
                } else {
                    type = "Other";
                    otherCount++;
                }

                // 6: Update totals and largest file
                totalSize += size;
                if (size > largestFileSize) {
                    largestFileSize = size;
                    largestFileName = fileName;
                }

                //  7: Print each file
                System.out.println("File: " + fileName + " | Extension: " + extension + " | Type: " + type + " | Size: " + size + " KB");
            } else {
                // Handle malformed record without continue
                System.out.println("Skipping malformed record: " + record);
            }
        }

        //   Summary
        System.out.println("\nInventory Summary");
        int totalFiles = documentCount + imageCount + audioCount + codeCount + otherCount;
        System.out.println("Total files: " + totalFiles);
        System.out.println("Total size: " + totalSize + " KB");
        System.out.println("Documents: " + documentCount);
        System.out.println("Images: " + imageCount);
        System.out.println("Audio: " + audioCount);
        System.out.println("Code: " + codeCount);
        System.out.println("Other: " + otherCount);
        System.out.println("Largest file: " + largestFileName + " (" + largestFileSize + " KB)");
    }
}
