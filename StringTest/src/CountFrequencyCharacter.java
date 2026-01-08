import java.util.Scanner;

public class CountFrequencyCharacter {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word : ");
        String str = sc.next();

        String out = "";
        for (int i = 0;i<str.length();i++){
            int counter = 0;
            out += str.charAt(i) ;
            for (int j = 0; j<str.length();j++){
                if (str.charAt(i) == str.charAt(j)){
                    counter++;
                }
            }
            out += counter;
        }

        System.out.println(out);
    }

}
