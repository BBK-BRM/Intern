import java.util.Scanner;

public class LongestWordSentences {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentences : ");
        String str = sc.nextLine();

        String[] word = str.split(" ");
        String longestWord = "" ;

        for (int i = 0;i < word.length; i++){
            for (int j = i+1; j< word.length;j++){
                if (word[i].length()>=word[j].length()){
                    longestWord = word[i];
                }
            }
        }
        System.out.println("Longest Word : "+longestWord);
    }
}
