import java.util.*;
public class GradeCalculator {
    public static String calculateGrade(double average) {

        if(average >= 90)        return "A";
        else if (average >= 80)  return "B";
        else if (average >= 70)  return "C";
        else if (average >= 60)  return "D";
        else if (average >= 50)  return "E";
        else    return "F";

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total number of Subjects : ");
        int numOfSubject = sc.nextInt();
        double [] marks = new double[numOfSubject];
        double total =0;

        // take input
          
        for(int i =1 ; i<= numOfSubject ; i++){
            System.out.println("Enter marks of subject " + i + " out of 100 marks ");
            double mark = sc.nextDouble();
            // Invalid input
            while (mark < 0 || mark > 100) {
                System.out.println("Invalid marks \n Enter marks between ( 0 to 100)");
                mark = sc.nextDouble();
            }
            marks[i-1] = mark;
            total += mark;
        }

        // Calculate average 
        double average = total/numOfSubject;

        // find grade of student 
        String grade = calculateGrade(average);

        // print result
        System.out.println("--------************--------");
        System.out.println("Total marks : " + total + "/" + (numOfSubject*100));
        System.out.println("Percentage : " + average + "%");
        System.out.println("Grade : " + grade);
        System.out.println("--------************--------");
        sc.close();

    }
}
    

