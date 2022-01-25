package lesson1;

 public class Car implements Movable{
   private int speed;
   private String color;
   private Engine engine;
     Car(int speed, String color, Engine engine) {
        this.speed = speed;
        this.color = color;
        this.engine = engine;
    }
    public void start() {
        System.out.println("Car starting");
    }
    public void open(){
        System.out.println("Car is open");}
    @Override
    public void stop() {
        System.out.println("Car is stopping");
    }
    @Override
    public void move() {
        System.out.println("Car is moving");
    }
}
