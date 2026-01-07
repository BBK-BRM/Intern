abstract class Shape {
    abstract void sayName();
}

class Rectangle extends Shape{
    @Override
    void sayName(){
        System.out.println("This is a Rectangle");
    }
}

class Circle extends Shape{
    @Override
    void sayName(){
        System.out.println("This is a Circle");
    }
}

class Main{
    static void main() {

        Shape r = new Rectangle();
        r.sayName();

        Shape c = new Circle();
        c.sayName();


    }
}
