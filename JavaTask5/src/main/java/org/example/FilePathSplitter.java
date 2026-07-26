package org.example;
import java.util.Scanner;
public class FilePathSplitter {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path : ");
        String path = scanner.nextLine().strip();
        if(path.isEmpty() || path.isBlank() || !path.contains("\\")) {
            System.out.println("Invalid file name.");
        }
        if(path.contains("\\")){
            String newPath = path.replace("\\","/");
            System.out.println("the new path: "+ newPath);
        }


        // String [] Parts= path.split("/"); //Parts[0] ,Parts[1] ,Parts[2]

        Integer lastSlash = path.lastIndexOf('/');

        String folder = "";
        String fileName = "";
        String extension = "none";

       // Check if there is at least one slash
        if (lastSlash >= 0) {
            folder = path.substring(0, lastSlash);
            fileName = path.substring(lastSlash + 1);
        } else {

            fileName = path;
        }

        Integer lastDot = fileName.lastIndexOf('.');
        if (lastDot >= 0) {
            extension = fileName.substring(lastDot + 1);
        }

        // Decide path style
        String pathStyle;
        if (path==path) {
            pathStyle = "Windows Path";
        } else {
            pathStyle = "Unix Path";
        }

        //  Print results
        System.out.println("Path: " + path);
        System.out.println("Folder: " + folder);
        System.out.println("File Name: " + fileName);
        System.out.println("Extension: " + extension);
        System.out.println("Path Style: " + pathStyle);

        scanner.close();

    }
}
