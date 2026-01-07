import java.util.Scanner;

public interface Bank {
    void deposit(float current_anoumt, float deposited_amount);
    void withdrawl(float current_anoumt, float withdraw_amount);
}

class Main implements Bank{
    @Override
    public void deposit(float current_anoumt, float deposited_amount) {
        current_anoumt += deposited_amount;
        System.out.println("Deposited Amount : "+deposited_amount);
        System.out.println("Current Amount : "+ current_anoumt);
    }

    public void withdrawl(float current_anoumt, float withdraw_amount) {
        current_anoumt -= withdraw_amount;
        System.out.println("withdrawl Amount : "+withdraw_amount);
        System.out.println("Current Amount : "+ current_anoumt);
    }

    void main() {
        float current_amount;

        Scanner current = new Scanner(System.in);
        System.out.print("Enter the current Amount : ");
        current_amount = current.nextFloat();

        Scanner opt = new Scanner(System.in);
        System.out.println("Select the following (1/2) \n" +
                "1.Withdraw \n" +
                "2.Deposit");
        int option = opt.nextInt();

        try {
            switch (option){
                case 1:
                    Scanner obj1 = new Scanner(System.in);
                    System.out.print("Enter the amount to withdraw : ");
                    float withdraw_amount = obj1.nextFloat();

                    withdrawl(current_amount,withdraw_amount);
                    break;
                case 2:
                    Scanner obj = new Scanner(System.in);
                    System.out.print("Enter the amount to deposit : ");
                    float deposit_amount = obj.nextFloat();

                    deposit(current_amount,deposit_amount);
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        }catch (Exception e){
            System.out.println("please select valid Option.");
        }
    }
}