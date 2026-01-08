import java.util.Scanner;

public class RemoveWhiteSpaces {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentences : ");
        String str = sc.nextLine();

        String removedSpaces = str.replace(" ","");

        System.out.println("Removed whitespaces : " + removedSpaces);
    }
}
