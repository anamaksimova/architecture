package lesson1.partTree;

public class Triangle extends Figure{
    public Triangle(int side, int height) {
        this.side = side;
        this.height = height;
    }

    int side;
    int height;
    @Override
    double area() {
        return 0.5*side*height;
    }

    @Override
    public void printArea() {
        System.out.println("Area of a Triangle "+ area());
    }
}
