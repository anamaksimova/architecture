package lesson1.partTree;

public class Circle extends Figure{
    int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double Area() {
        return Math.PI*radius*radius;
    }

    @Override
    public void PrintArea() {
        System.out.println("Area of a circle is "+ Area());
    }
}
