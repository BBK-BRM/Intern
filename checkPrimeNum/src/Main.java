import java.util.Scanner;

public class Main {
    static boolean isPrime(int num){
        if(num<=1){
            return false;
        }
        for (int i = 2; i < num ; i++ ){
            if(num % i == 0){
              return false;
            }
        }
        return true;
    };
    static void main() {
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter a  number : ");
        int num = obj.nextInt();

        if(isPrime(num)){
            System.out.println(num + " is a  prime number.");
        }else{
            System.out.println(num + " is not a  prime number.");
        }

    }
}
