import java.util.Scanner;

public class Main {
    static int reverseNum(int num){
        int reverse = 0;
        while(num>0){
            reverse = reverse * 10 + num % 10;
            num /= 10;
        }
       return reverse;
    };
    static void main() {

        Scanner obj = new Scanner(System.in);
        System.out.print("Enter a number to  check Pallindrome : ");

        int num = obj.nextInt();
        int reverseNumber = reverseNum(num);

        if(num == reverseNumber){
            System.out.println(num + " is a palindrome");
        }else {
            System.out.println(num + " is not a palindrone");
        }
    }
}
