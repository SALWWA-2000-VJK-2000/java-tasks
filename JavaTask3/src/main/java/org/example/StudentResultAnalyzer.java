package org.example;

public class StudentResultAnalyzer {
    public static void main(String[] args) {
        String studentName = "Salwa";
        Integer mathMark = 90;
        Integer englishMark = 99;
        Integer computerMark = 99;

        // Validate marks
        Boolean validMarks = validateMarks(mathMark, englishMark, computerMark);
        if (!validMarks) {
            System.out.println("Invalid marks");
        } else {
            // Calculate total marks
            Integer totalMarks = calculateTotal(mathMark, englishMark, computerMark);

            // Calculate Average marks
            Double averageMark = calculateAverage(totalMarks, 3);

            // Calculate grade
            String grade = calculateGrade(averageMark);

            // Check performance status
            String performance = checkPerformance(grade);

            // Display report
            displayReport(studentName, mathMark, englishMark, computerMark,
                    totalMarks, averageMark, grade, performance);
        }
    }

    // Method to validate marks
    public static Boolean validateMarks(Integer math, Integer english, Integer computer) {
        return (math >= 0 && math <= 100) &&
                (english >= 0 && english <= 100) &&
                (computer >= 0 && computer <= 100);
    }

    // Method to calculate total marks
    public static Integer calculateTotal(Integer math, Integer english, Integer computer) {
        return math + english + computer;
    }

    // Method to calculate average mark
    public static Double calculateAverage(Integer totalMarks, Integer numberOfSubjects) {
        return (double) totalMarks / numberOfSubjects;
    }

    // Method to calculate grade
    public static String calculateGrade(Double averageMark) {
        if (averageMark >= 90) {
            return "A";
        } else if (averageMark >= 80) {
            return "B";
        } else if (averageMark >= 70) {
            return "C";
        } else if (averageMark >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    // Method to check performance status
    public static String checkPerformance(String grade) {
        if (grade.equals("A")) {
            return "Excellent Performance";
        } else if (grade.equals("B")) {
            return "Good Performance";
        } else if (grade.equals("C")) {
            return "Average Performance";
        } else if (grade.equals("D")) {
            return "Below Average Performance";
        } else {
            return "Poor Performance";
        }
    }

    // Method to display student report
    public static void displayReport(String studentName, Integer math, Integer english, Integer computer,
                                     Integer totalMarks, Double averageMark, String grade, String performance) {
        System.out.println(" Student Report");
        System.out.println("Student Name: " + studentName);
        System.out.println("Math Mark: " + math);
        System.out.println("English Mark: " + english);
        System.out.println("Computer Mark: " + computer);
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Mark: " + averageMark);
        System.out.println("Final Grade: " + grade);
        System.out.println("Performance Status: " + performance);
    }
}
