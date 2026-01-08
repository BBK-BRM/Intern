import java.util.Scanner;

public class CountVowelConsunant {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word to count vowel and consunent :");
        String str = sc.next();

        int vowel = 0;
        int consunent = 0;

        for (int i = 0; i<str.length();i++){
            char ch = str.toLowerCase().charAt(i);
            if(ch=='a' || ch =='e'||ch =='i'||ch =='o'||ch =='u'){
                vowel++;
            }else {
                consunent++;
            }
        }

        System.out.println("Vowel : "+vowel);
        System.out.println("Consunent : "+consunent);
    }
}