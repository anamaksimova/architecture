package ru.geekbrains;

import ru.geekbrains.adapter.AsianLion;
import ru.geekbrains.adapter.Hunter;
import ru.geekbrains.adapter.WildDog;
import ru.geekbrains.adapter.WildDogAdapter;
import ru.geekbrains.bridge.About;
import ru.geekbrains.bridge.Careers;
import ru.geekbrains.bridge.DarkTheme;
import ru.geekbrains.composite.Designer;
import ru.geekbrains.composite.Developer;
import ru.geekbrains.composite.Organization;
import ru.geekbrains.decorator.Coffee;
import ru.geekbrains.decorator.MilkCoffee;
import ru.geekbrains.decorator.SimpleCoffee;
import ru.geekbrains.decorator.WhipCoffee;
import ru.geekbrains.facade.Computer;
import ru.geekbrains.facade.ComputerFacade;
import ru.geekbrains.proxy.Door;
import ru.geekbrains.proxy.LabDoor;
import ru.geekbrains.proxy.SecuredDoor;

public class Main {
    public static void main(String[] args) {
        // 1. adapter example
//        WildDog dog = new WildDog();
//        WildDogAdapter wda = new WildDogAdapter(dog);
//        Hunter hunter= new Hunter();
//
//        System.out.println(hunter.hunt(wda));

        //2. bridge example
//        DarkTheme dt = new DarkTheme();
//
//        About about = new About(dt);
//        Careers careers = new Careers(dt);
//
//        System.out.println(about.getContent());
//        System.out.println(careers.getContent());

        //3. composite example

//        Developer jo = new Developer("Jo", 12000.0f);
//        Designer jay = new Designer("Jay", 15000.0f);
//
//        Organization org = new Organization();
//        org.addEmployee(jo);
//        org.addEmployee(jay);
//        System.out.println(org.getNetSalaries());

        //4. Decorator example
//        Coffee someCoffee = new SimpleCoffee();
//        System.out.println(someCoffee.getCost());
//        System.out.println(someCoffee.getDescription());
//        Coffee someCoffee1 = new MilkCoffee(someCoffee);
//        System.out.println(someCoffee1.getCost());
//        System.out.println(someCoffee1.getDescription());
//        Coffee someCoffee2 = new WhipCoffee(someCoffee1);
//        System.out.println(someCoffee2.getCost());
//        System.out.println(someCoffee2.getDescription());


        //5.Facade example
//        ComputerFacade computer = new ComputerFacade(new Computer());
//        computer.turnOn();
//        computer.turnOff();

        //6.Proxy
        SecuredDoor door = new SecuredDoor(new LabDoor());
        door.open("$ecr@t");
        door.open("");
        door.close();










    }
}
