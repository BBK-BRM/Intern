import java.util.Scanner;

public class NumberCheck {
//    void numberCheck(int n){
//        if (n == 0) {
//            System.out.println(n + " is zero");
//        } else if (n > 0) {
//            System.out.println(n + " is positive");
//        } else {
//            System.out.println(n + " is negative");
//        }
//    }
    static void main() {
        try {
            Scanner sc  = new Scanner(System.in);
            System.out.print("Enter a number  : ");
            int num = sc.nextInt();

            if (num == 0) {
                System.out.println(num + " is zero");
            } else if (num > 0) {
                System.out.println(num + " is positive");
            } else {
                System.out.println(num + " is negative");
            }

//            NumberCheck nc = new NumberCheck();
//            nc.numberCheck(num);

//            anonymous object creation
//            new NumberCheck().numberCheck(num);

        }catch(Exception e){
            System.out.println("Enter a valid Number only.");
        }
    }
}