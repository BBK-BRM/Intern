import java.util.Scanner;

public class StringReverse {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word to reverse : ");
        String s = sc.next();
        String revS = "";
        for (int i = s.length()-1; i>=0; i--){
            revS = revS + s.charAt(i);
        }
        System.out.println(revS);

        String name = "bibek";
        name = "Baram";
        System.out.println(name);
    }
}
