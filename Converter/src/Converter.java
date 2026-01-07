import java.util.Scanner;

public class Converter {
    public static float celsiusToFaren(float celsius) {
        return (celsius*9/5)+32;
    }

    public static float kmToMiles(float km){
        return (km/1.609f);
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select the Option (1,2,3) ? " );
        System.out.println("1.oC to oF");
        System.out.println("2.km to miles");
        System.out.println("3.Exit");
        int opt = sc.nextInt();

        switch (opt) {
            case 1:
                Scanner obj = new Scanner(System.in);
                System.out.print("Enter the Celsius to Convert into Farenheight : ");
                float cel = obj.nextFloat();
                System.out.println("Converted Farenheight : " + celsiusToFaren(cel));
                break;
            case 2:
                Scanner obj2 = new Scanner(System.in);
                System.out.print("Enter the km to Convert into mile : ");
                float km = obj2.nextFloat();
                System.out.println("Converted mile : " + kmToMiles(km));
                break;
            case 3:
                //return;
                System.exit(0);
            default :
                System.out.println("Enter Valid Option");
        }
    }
}