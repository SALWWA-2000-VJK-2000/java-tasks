package org.example;

public class StudentGradeCalculator {
    static  void  main(){
        Double grade1 = 85.0 ;
        Double grade2 = 90.0 ;
        Double grade3 = 80.0;
        Double average = (grade1 +grade2 + grade3)/ 3; //here we sum the 3 grades and divide them with 3
        String status  ;


        if (average>=90){
             status = "Excellent" ;
        } else if (average >= 75) {
             status = "Good" ;
        } else if (average >= 60) {
             status = "Pass" ;
        } else {
             status = "Fail" ;
        }

        System.out.println("Grade 1: "+ grade1);
        System.out.println("Grade 2: "+ grade2);
        System.out.println("Grade 3: "+ grade3);
        System.out.println("Average : "+ average);
        System.out.println("Status: "+ status);

    }
}
