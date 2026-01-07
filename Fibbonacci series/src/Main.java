//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int num1 = 0;
        int num2 = 1;
        System.out.println(num1);
        do {
            System.out.println(num2);
            int fibSeries = num1 + num2;
            num1 = num2;
            num2 = fibSeries;
        }while(num2<10);
    }
}
