abstract class Shape {
    void calculateArea(float r){
        System.out.println("Area of circle : "+(Math.PI*r*r));
    }
    void calculateArea(float l,float b){
        System.out.println("Area of Rectangle : "+(l * b));
    }
}

class Main extends Shape{
    static void main() {
        Main m = new Main();
        m.calculateArea(3);
        m.calculateArea(2,3);

    }
}
