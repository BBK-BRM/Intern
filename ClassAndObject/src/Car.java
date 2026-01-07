public class Car {
    String brand;
    String model;
    int speed;

    int increaseSpeed(int speed){
        return speed+1;
    }

    static void main() {
        Car c1 = new Car();
        c1.brand = "Tesla";
        c1.model = "Model X";
        c1.speed = 36;

        System.out.println("Brand : "+c1.brand);
        System.out.println("Model : "+c1.model);
        
        System.out.println("Current Speed : " + c1.speed);
        System.out.println("After speed Increase : " +c1.increaseSpeed(c1.speed));
    }
}
