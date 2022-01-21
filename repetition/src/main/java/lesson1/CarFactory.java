package lesson1;

public class CarFactory {
    public static Car makeCar(int speed, String color, Engine engine){
        return new Car(speed, color, engine);
    }
}
