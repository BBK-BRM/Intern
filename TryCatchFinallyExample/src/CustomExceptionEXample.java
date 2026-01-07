import java.util.Scanner;

public class CustomExceptionEXample {
    static void checkAge(int age){
        if(age < 18){
            throw new ArithmeticException("Age Must be greater than 18");
        }
    }
    static void main() {
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter your age : ");
        int age = obj.nextInt();
        checkAge(age);
    }
}
