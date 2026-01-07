import java.util.Scanner;

public class Factorial {
    static void main() {
        int factorial = 1;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to find factorial : ");
        int num = sc.nextInt();

        for (int i = 1;i<=num;i++){
//            factorial = factorial  * i;
            factorial *= i;
        }

        System.out.println("Factoral : "+factorial);
    }
}
