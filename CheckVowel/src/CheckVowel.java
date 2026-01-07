import java.util.Scanner;

public class CheckVowel {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Character : ");
        char c = sc.next().toLowerCase().charAt(0);

        if (c == 'a'||c == 'e'||c == 'i'||c == 'o'||c == 'u'){
            System.out.println(c+" is a vowel");
        }else {
            System.out.println(c + " is a consunant");
        }
    }
}
