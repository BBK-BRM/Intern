import java.util.Scanner;

public class Main {
    static void main() {
        Scanner obj1 = new Scanner(System.in);
        System.out.print("Enter first number :");
        int num1 = obj1.nextInt();

        Scanner obj2 = new Scanner(System.in);
        System.out.print("Enter second number :");
        int num2 = obj2.nextInt();

        Scanner obj3 = new Scanner(System.in);
        System.out.print("Enter third number :");
        int num3 = obj3.nextInt();

        int largest = (num1 > num2 && num1 > num3) ? num1:((num2>num3) ? num2: num3);
        System.out.println("largest Among three numbers is "+ largest);

    }
}
