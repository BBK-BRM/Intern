import java.util.Scanner;

public class PalindromeString {
    String reverseStr(String s){
        String revS = "";
        for (int i = s.length()-1; i>=0; i--){
            revS = revS + s.charAt(i);
        }
        return revS;
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word to check palindrone : ");
        String str = sc.next();

        PalindromeString ps = new PalindromeString();
        if (str.equals(ps.reverseStr(str))){
            System.out.println(str+" is a palindrone");
        }else{
            System.out.println(str+" is not a palindrone");
        }

    }
}
