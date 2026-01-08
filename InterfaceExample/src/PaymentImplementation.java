public class PaymentImplementation implements Payemnt {
    @Override
    public void cashPayment(){
        System.out.println("This is cash Payment");
    }

    @Override
    public void cardPayment() {
        System.out.println("This is card payment");
    }

    static void main() {
        PaymentImplementation pi = new PaymentImplementation();
        pi.cardPayment();
        pi.cashPayment();
    }
}
