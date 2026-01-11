import java.util.Scanner;

class CustomException extends Exception{
    public CustomException(String msg){
        System.out.println(msg);
    }
}

public class CustomExceptionEXample {
    static void checkAge(int age)throws CustomException{
        if(age < 18){
            throw new CustomException("Age Must be greater than 18");
        }
    }
    static void main() {
            Scanner obj = new Scanner(System.in);
            System.out.print("Enter your age : ");
            int age = obj.nextInt();
            try {
                checkAge(age);
                System.out.println("you are 18+");
            }catch (CustomException ce){
                System.out.println("Custom Exception caught from catch.");
            }
    }
}
