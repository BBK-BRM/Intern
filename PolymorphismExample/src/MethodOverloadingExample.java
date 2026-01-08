public class MethodOverloadingExample {
    int add (int n1,int n2){
        return n1 + n2;
    }

    double add(double n1, double n2){
        return n1 + n2;
    }

    static void main() {
        MethodOverloadingExample mo = new MethodOverloadingExample();
        System.out.println("Add(int) : " + mo.add(2,3) );
        System.out.println("Add(double) : " + mo.add(2.54,3.78) );
    }
}
