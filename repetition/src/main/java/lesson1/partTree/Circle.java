package lesson1.partTree;

public class Circle extends Figure{
    int radius;

    public Circle(int radius) {
        this.radius = radius;
    }


    @Override
    double area() {
        return Math.PI*radius*radius;
    }

    @Override
    public void printArea() {
        System.out.println("Area of a circle is "+ area());
    }
}
