package org.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AdvancedArrayListStudentManagementSystem {
    static public void main(){
        ArrayList<String> students = new ArrayList<>();
        // add elements
        students.add("Ali");
        students.add("Sara");
        students.add("Omar");
        students.add("Salwa");
        students.add("Reem");
        students.add("Salima");
        students.add("Taqwa");
        students.add("Jokah");
        students.add("Intisar");
        students.add("Mayada");

        //Total number of students.
        System.out.println("Total: "+ students.size());
        for (int i=0; i< students.size(); i++ ){
            System.out.println("Student" + i + ": " + students.get(i));
        }

        // Add New Students
        //Add a student at the end of the list.
        students.add("Reham");
        System.out.println( students);

        //Add a student at a specific position.
        Scanner scanner = new Scanner(System.in);
        // Ask user for index and value
        System.out.print("Enter index to insert at: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter student name: ");
        String student = scanner.nextLine();

        // Insert at the given position
        if (index >= 0 && index <= students.size()) {
            students.add(index, student);
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Invalid index. Valid range is 0 to " + students.size());
        }

        // Update Student Information
        System.out.print("Enter index : ");
        int updatedIndex = scanner.nextInt();
        if(updatedIndex>=0 && updatedIndex< students.size()){
            System.out.print("Enter new name: ");
            String newValue =scanner.next();
            //numbers[updatedIndex]= newValue;
            students.set(updatedIndex,newValue);
            System.out.println("Updated List: \n"+ students);
        }else{
            System.out.println("Invalid index");
        }

        //Search Student System
        System.out.println("Enter student name to search:");
        String target = scanner.next();

        if(students.contains(target)){
            int i = students.indexOf(target);
            System.out.println("Student found ");
            System.out.println("Index position: " + i);
        }else {
            System.out.println("Student not found. ");
        }

        // Remove Student System
        //Remove a student by name.
        System.out.println("Before: " + students);
        System.out.print("Enter student name to remove: ");
        String name = scanner.nextLine();
        if (students.remove(name)) {
            System.out.println("After removing " + name + ": " + students);
        } else {
            System.out.println("Student not found.");
        }
        // Remove by index
        System.out.print("\nEnter index to remove: ");
        int indexof = scanner.nextInt();
        if (indexof >= 0 && indexof < students.size()) {
            String removed = students.remove(indexof);
            System.out.println("After removing " + removed + ": " + students);
        } else {
            System.out.println("Invalid index.");
        }

        //Student List Analysis
        //Count total students.
        System.out.println("Total: "+ students.size());
        //Check if the list is empty.
        if(students==null){
            System.out.println("List is empty");
        }
        //Display the first student.
        System.out.println("First Student: " + students.get(0));

        //Display the last student.
        System.out.println("Last Student : "+ students.get(students.size()-1));

       //Sorting Students

        ArrayList<String> sortedStudents = new ArrayList<>(students); // copy
        Collections.sort(sortedStudents); // sort alphabetically
        System.out.println("Original List: " + students);
        System.out.println("Sorted List: " + sortedStudents);


        scanner.close();
    }
}
