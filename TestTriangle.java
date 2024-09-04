/*
 * Name: Triangle Class
 * Author: Leah Boalich
 * Date: September 3, 2024
 * Assignment: Module 2 Chapter 11 Exercise 1
 * Description: This program creates a Triangle class by extending a Geometric Object class.  A triangle object is created using input from the user.  The perimeter, area, color and filled value are then displayed.  
*/

/* Imports */
import java.util.Scanner;

//Test the Triangle class
public class TestTriangle {
   /*Main Module */
   public static void main(String args[]) {
      //Prompt user for sides
      System.out.print("Please enter the 3 sides of the triangle separater by a space: ");
      //Create input scanner
      Scanner input = new Scanner(System.in);
      //Read input into side variables
      double side1 = input.nextDouble();
      double side2 = input.nextDouble();
      double side3 = input.nextDouble();
      //Prompt user for color
      System.out.print("Please enter the color of the triangle: ");
      //Read input into color variable
      String color = input.next();
      //Prompt user to state if triangle is filled
      System.out.print("Please enter 'true' if the triangle is filled or 'false' if it is not: ");
      //Read input into filled variable
      boolean filled = input.nextBoolean();
      //Create Triangle object using given sides
      Triangle triangle1 = new Triangle(side1, side2, side3);
      //Set triangle color based on input
      triangle1.setColor(color);
      //Set if triangle is filled based on input
      triangle1.setFilled(filled);
      //Display the properites of the triangle
      System.out.print(triangle1.toStringMore());
      //Close the input scanner
      input.close();
   }
}

//Create Triangle class
class Triangle extends GeometricObject {
   /* Create 3 side attributes initialized to 1.0 */
   private double side1 = 1.0;
   private double side2 = 1.0;
   private double side3 = 1.0;

   /* Default Constructor */
   public Triangle() {
   }

   /* Constructor utilizing given side values */
   public Triangle(double newSide1, double newSide2, double newSide3) {
      this.side1 = newSide1;
      this.side2 = newSide2;
      this.side3 = newSide3;
   }

   /* Get side1 */
   public double getSide1() {
      return this.side1;
   }

   /* Get side2 */
   public double getSide2() {
      return this.side2;
   }

   /* Get side3 */
   public double getSide3() {
      return this.side3;
   }

   /* Return the triangle's area */
   public double getArea() {
      //Formulas used to calculate area
      double s = (this.side1 + this.side2 + this.side3) / 2;
      double area = Math.sqrt(s * (s - this.side1) * (s - this.side2) * (s - this.side3));
      return area;
   }
   
   /* Return the triangle's perimeter */
   public double getPerimeter() {
      //Formula to calculate perimeter
      double perimeter = this.side1 + this.side2 + this.side3;
      return perimeter;
   }

   /* Return the string representation of the triangle */
   public String toString() {
      return "Triangle: side1 = " + this.side1 + " side2 = " + this.side2 + " side3 = " + this.side3;
   }

   /* Return the string representation of the triangles properties */
   public String toStringMore() {
      //Create variables to hold the string of each property
      String areaString = "\nThe area is: " + this.getArea();
      String perimeterString = "\nThe perimeter is: " + this.getPerimeter();
      String colorString = "\nThe color is: " + super.getColor();
      String filledString = "\nIs the triangle filled? " + super.isFilled() + "\n";
      //Return the concacted strings
      return areaString + perimeterString + colorString + filledString;
   }
}
