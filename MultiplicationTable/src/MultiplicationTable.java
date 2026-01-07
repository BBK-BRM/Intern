import java.util.Scanner;

public class MultiplicationTable {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Multiplication table of : ");
        int num = sc.nextInt();

        System.out.println("------------------------------------------");
        System.out.println("Multiplication Table of "+num);
        System.out.println("------------------------------------------");
        int i = 1;
        while (i < 11) {
            System.out.println("\t"+num +" * "+ i + " = "+num*i);
            i++;
        }
        System.out.println("------------------------------------------");
    }
}
