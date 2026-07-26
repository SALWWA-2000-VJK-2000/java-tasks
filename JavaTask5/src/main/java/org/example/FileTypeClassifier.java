package org.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileTypeClassifier {
    static void main() {
        // Step 2: Create a list of file names
        List<String>file = new ArrayList<>();
        file.add("report.txt");
        file.add("presentation.pdf");
        file.add("notes.docx");
        file.add("photo.jpg");
        file.add("diagram.png");
        file.add("program.java");
        file.add("script.py");
        file.add("readme");

        // Step 3: Counters for categories
        Integer documentCount = 0;
        Integer imageCount = 0;
        Integer codeCount = 0;
        Integer otherCount = 0;

        // Step 4: Loop through the list
        for (String f: file){
            String type;
            Integer dot = file.lastIndexOf(".");
            if(dot== -1 ){ //-1 means No extension (other)
                type ="Other";
            }else{
                String extension = f.substring(dot + 1).toLowerCase();
                // Step 5: Classify by extension
                if (extension.equals("txt") || extension.equals("pdf") || extension.equals("docx")) {
                    type = "Document";
                    documentCount++;
                } else if (extension.equals("jpg") || extension.equals("jpeg") || extension.equals("gif") || extension.equals("png")) {
                    type = "Image";
                    imageCount++;
                } else if (extension.equals("java") || extension.equals("py")|| extension.equals("js")) {
                    type = "Code";
                    codeCount++;
                } else {
                    type = "Other";
                    otherCount++;
                }
            }
            // Step 6: Print each file name with its type
            System.out.println("File: " + file + " | Type: " + type);
        }
        // Step 6: Print totals
        System.out.println("\nSummary:");
        System.out.println("Total Files: " + file.size());
        System.out.println("Documents: " + documentCount);
        System.out.println("Images: " + imageCount);
        System.out.println("Code Files: " + codeCount);
        System.out.println("Others: " + otherCount);

    }
}
