import lesson1.Car;
import lesson1.CarFactory;
import lesson1.Engine;
import lesson1.Person;
import lesson1.partTree.Circle;
import lesson1.partTree.Figure;
import lesson1.partTree.Triangle;

public class Main {
    public static void main(String[] args) {
        //task 1
        Person person = new Person.Builder()
                .withFirstName("Alex")
                .withMiddleName("Olegovich")
                .withLastName("Ivanov")
                .withCountry("Russia")
                .withAddress("Ufa")
                .withGender("male")
                .withPhone("555")
                .withAge(23)
                .build();
        System.out.println(person.toString());
        //по заданию 2. обьединила два интерфейса в один movable. класс car перестал быть абстрактным, добавила фабрику для
       // создания машин
        Car lorry = CarFactory.makeCar(30, "blue", new Engine("1"));
        Car lightWeightCar = CarFactory.makeCar(50, "white", new Engine("2"));
        lorry.start();
        lightWeightCar.move();

    //task 3
        Figure circle= new Circle(5);
        circle.PrintArea();
        Triangle tr = new Triangle(5,5);
        tr.PrintArea();
    }







}
