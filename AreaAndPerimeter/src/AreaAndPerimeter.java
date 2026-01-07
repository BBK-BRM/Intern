public class AreaAndPerimeter {
    void circleAreaAndPerimeter(float r){
        System.out.println("Area of circle : " + (Math.PI*Math.pow(r,2)));
        System.out.println("perimeter of Circle : " + (2*3.14*r));
    }

    void rectangleAreaAndPerimeter(float l,float b){
        System.out.println("Area of Rectangle : " + (l*b));
        System.out.println("perimeter of Rectangle : " + (2*(l+b)));
    }

    static void main() {
        AreaAndPerimeter ap = new AreaAndPerimeter();
        ap.circleAreaAndPerimeter(2);

        System.out.println();
        ap.rectangleAreaAndPerimeter(2,3);
    }
}
