package org.example;
import java.util.Scanner;
public class FileNameAnalyzer {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String file = scanner.nextLine().strip();
        if(file == null || file.isBlank() ||
                !file.contains(".") ||
                file.startsWith(".") ||
                file.endsWith(".")) {
            System.out.println("Invalid file name.");
        }
        //
        Integer dot = file.lastIndexOf(".");
        String baseName = file.substring(0, dot);
        String extension = file.substring(dot + 1).toLowerCase();
        String classification;
        //classification
        if (extension.equals("txt") ||
                extension.equals("pdf") ||
                extension.equals("docx")) {
            classification = "Document";
        } else if (extension.equals("jpg") ||
                extension.equals("jpeg") ||
                extension.equals("gif") ||
                extension.equals("png")) {
            classification = "Image";
        } else if (extension.equals("mp3") ||
                extension.equals("wav")) {
            classification = "Audio";
        } else {
            classification = "Other";
        }
        //Display the result
        System.out.println("Base Name: " + baseName);
        System.out.println("Extension: " + extension);
        System.out.println("classification: "+ classification );
    }
}
