public class ExceptionEXample {
    int num = 10;
    int divisor = 2;

    static void main() {
        try{

            ExceptionEXample exm = new ExceptionEXample();
            int result = exm.num/exm.divisor;

        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by Zero(0)");
        }finally {
            System.out.println("This is finally block.");
        }
    }
}