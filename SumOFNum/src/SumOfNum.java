import java.util.Scanner;

public class SumOfNum {
    static void main() {
        int sum = 0;
        Scanner  sc = new Scanner(System.in);
        System.out.print("Enter a number upto which to find sum : ");
        int num = sc.nextInt();

        for (int i = 1;i<=num;i++){
            sum += i;
        }

        System.out.println("Sum : " + sum);
    }
}
