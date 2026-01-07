import java.util.Scanner;

public class LeapYearCheck {
    void leapYearCheck(int year){
        boolean leapYear;
        if(year % 4 == 0){
            leapYear = true;
            if(year % 100 == 0) {
                if (year % 400 == 0) {
                    leapYear = true;
                } else {
                    leapYear = false;
                }
            }
        }else{
            leapYear = false;
        }

        if(leapYear){
            System.out.println(year+ " is a leap year");
        }else{
            System.out.println(year + " is not a leap year");
        }
    }
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter year : ");
        int year = sc.nextInt();

        LeapYearCheck lyc = new LeapYearCheck();
        lyc.leapYearCheck(year);
    }
}
