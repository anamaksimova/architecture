import lesson1.Car;
import lesson1.CarFactory;
import lesson1.Engine;
import lesson1.Person;
import lesson1.partTree.Circle;
import lesson1.partTree.Triangle;
import lesson2.MyArrayList;
import lesson2.MyLinkedList;

public class Main {
    public static void main(String[] args) {
//        //task 1
//        Person person = new Person.Builder()
//                .withFirstName("Alex")
//                .withMiddleName("Olegovich")
//                .withLastName("Ivanov")
//                .withCountry("Russia")
//                .withAddress("Ufa")
//                .withGender("male")
//                .withPhone("555")
//                .withAge(23)
//                .build();
//        System.out.println(person.toString());
//        //по заданию 2. обьединила два интерфейса в один movable. класс car перестал быть абстрактным, добавила фабрику для
//       // создания машин
//        Car lorry = CarFactory.makeCar(30, "blue", new Engine("1"));
//        Car lightWeightCar = CarFactory.makeCar(50, "white", new Engine("2"));
//        lorry.start();
//        lightWeightCar.move();
//
//    //task 3
//        Circle circle= new Circle(5);
//        circle.printArea();
//        Triangle tr = new Triangle(5,5);
//        tr.printArea();

        //lesson2
//        MyArrayList<Integer> mal = new MyArrayList<>();
//        mal.add(5);
//        mal.add(3);
//        mal.add(18);
//        System.out.println(mal);
//        System.out.println(mal.isEmpty());
//        System.out.println(mal.size());
//        System.out.println(mal.indexOf(3));
//        mal.add(66);
//        mal.add(55);
//        System.out.println(mal);
//        mal.add(7);
//        System.out.println(mal);
//        mal.add(8);
//        System.out.println(mal);
//        System.out.println(mal.delete(66));
//        System.out.println(mal);
//        System.out.println(mal.delete(1));
//        mal.add(1,1);
//        System.out.println(mal);
        MyLinkedList<Integer> mll = new MyLinkedList<>();
        mll.addFirst(5);
        mll.addFirst(4);
        mll.addFirst(3);
        mll.addFirst(2);
        mll.addFirst(1);

        mll.add(66);System.out.println(mll);
        System.out.println(mll.indexOf(66));
        mll.delete(3);
        System.out.println(mll);
        mll.delete(66);

        mll.add(2,77); System.out.println(mll);
    }







}
