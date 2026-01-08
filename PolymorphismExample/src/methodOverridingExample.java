class Vechile{
    void starts(){
        System.out.println("Vechile Started");
    }
}

class Bike extends Vechile{
    @Override
    void starts(){
        System.out.println("Bike Started");
    }
}

class Car extends Vechile{
    @Override
    void starts(){
        System.out.println("Car Started");
    }
}
public class methodOverridingExample {
    static void main() {
        Vechile bike =  new Bike();
        bike.starts();

        Vechile car = new Car();
        car.starts();
    }

}
