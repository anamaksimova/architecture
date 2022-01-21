package lesson1.partTree;

public class Triangle extends Figure{
    public Triangle(int side, int height) {
        this.side = side;
        this.height = height;
    }

    int side;
    int height;
    @Override
    public double Area() {
        return 0.5*side*height;
    }

    @Override
    public void PrintArea() {
        System.out.println("Area of a Triangle "+ Area());
    }
}
