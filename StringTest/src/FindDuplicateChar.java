import java.util.Scanner;

public class FindDuplicateChar {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word : ");
        String str = sc.next();

        String duplicateChar = "";

        for (int i = 0; i < str.length(); i++){
            for (int j = i+1; j < str.length(); j++){
                if(str.charAt(i) == str.charAt(j)){
                    duplicateChar += "" +str.charAt(i);
                }
            }
        }
        System.out.println("Duplicate Characters : "+duplicateChar);
    }
}