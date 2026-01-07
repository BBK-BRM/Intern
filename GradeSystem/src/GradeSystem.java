import java.util.Scanner;

public class GradeSystem {
    static void main() {
        Scanner sc  = new Scanner(System.in);
        System.out.print("Enter the  marks : ");
        int marks= sc.nextInt();

        if (marks >= 80){
            System.out.println("Grade : A");
        } else if (marks >= 60 ) {
            System.out.println("Grade : B");
        } else if (marks >= 40) {
            System.out.println("Grade : c");
        }else {
            System.out.println("Grade : Fail");
        }
    }
}
