import java.util.Scanner;

public class CharacterASCII {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Character to find ASCII : ");
        char ch = sc.next().charAt(0);
        System.out.println("ASCII value of "+ch+" : " + (int) ch);
    }
}
