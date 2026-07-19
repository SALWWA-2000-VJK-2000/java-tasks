package org.example;

public class CircleCalculator {
    static  void main(){

        String r =IO.readln("Enter the Circle radius:");
        Integer radius = new  Integer(r);
        Double area;
        Double circumference = 0.0;
        Double pi =3.14;
        String classification;

        if(radius<=0){
            System.out.println( "Invalid radius. Radius must be greater than zero." );
        }else{
            area = pi*radius*radius;
            circumference = 2 * pi * radius;
            System.out.println("Area:"+ area);
            System.out.println("Circumference: " + circumference);
        }
        if(radius<5){
            classification="Small Circle";
        } else if (radius<=15) {
            classification = "Medium Circle ";
        }else {
            classification=" Large Circle  ";
        }
        System.out.println("Radius: " +radius);
        System.out.println("Classification: " + classification);
    }
}
