package ru.geekbrains;

import ru.geekbrains.behavioralPatterns.chainOfResponsibility.Bank;
import ru.geekbrains.behavioralPatterns.chainOfResponsibility.Bitcoin;
import ru.geekbrains.behavioralPatterns.chainOfResponsibility.Paypal;
import ru.geekbrains.behavioralPatterns.command.Bulb;
import ru.geekbrains.behavioralPatterns.command.RemoteControl;
import ru.geekbrains.behavioralPatterns.command.TurnOff;
import ru.geekbrains.behavioralPatterns.command.TurnOn;
import ru.geekbrains.behavioralPatterns.mediator.ChatRoom;

import ru.geekbrains.behavioralPatterns.memento.Editor;
import ru.geekbrains.behavioralPatterns.memento.EditorMemento;
import ru.geekbrains.behavioralPatterns.state.LowerCase;
import ru.geekbrains.behavioralPatterns.state.TextEditor;
import ru.geekbrains.behavioralPatterns.state.UpperCase;
import ru.geekbrains.behavioralPatterns.strategy.BubbleSortStrategy;
import ru.geekbrains.behavioralPatterns.strategy.QuickSortStrategy;
import ru.geekbrains.behavioralPatterns.strategy.Sorter;
import ru.geekbrains.behavioralPatterns.templateMethod.AndroidBuilder;
import ru.geekbrains.behavioralPatterns.visitor.Lion;
import ru.geekbrains.behavioralPatterns.visitor.Monkey;
import ru.geekbrains.behavioralPatterns.visitor.Speak;
import ru.geekbrains.structuralPatterns.proxy.LabDoor;
import ru.geekbrains.structuralPatterns.proxy.SecuredDoor;

import java.util.ArrayList;

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
//        SecuredDoor door = new SecuredDoor(new LabDoor());
//        door.open("$ecr@t");
//        door.open("");
//        door.close();

        //1.chainOfResponsibility
//        Bank bank = new Bank(100);          // Bank with balance 100
//        Paypal paypal = new Paypal(200);      // Paypal with balance 200
//        Bitcoin bitcoin = new Bitcoin(300);    // Bitcoin with balance 300
//
//        bank.setNext(paypal);
//        paypal.setNext(bitcoin);
//
//
//        bank.pay(259);

        //2. command
//        Bulb bulb = new Bulb();
//
//        TurnOn turnOn = new TurnOn(bulb);
//        TurnOff turnOff = new TurnOff(bulb);
//
//        RemoteControl remote = new RemoteControl();
//        remote.submit(turnOn); // Bulb has been lit!
//        remote.submit(turnOff); // Darkness!

        //3.

        //4.mediator
//        ChatRoom mediator = new ChatRoom();
//
//        User john = new User("John Doe", mediator);
//        User jane = new User("Jane Doe", mediator);
//
//        john.send("Hi there!");
//        jane.send("Hey!");
        //5. memento
//        Editor editor = new Editor();
//        editor.type("This is the first sentence.");
//        editor.type("This is second.");
//// Save the state to restore to : This is the first sentence. This is second.
//        EditorMemento saved = editor.save();
//// Type some more
//        editor.type("And this is third.");
//// Output: Content before Saving
//        System.out.println(editor.getContent()); // This is the first sentence. This is second. And this is third.
//// Restoring to last saved state
//        editor.restore(saved);
//        editor.getContent(); // This is the first sentence. This is second.

        //6. visitpr
//        Monkey monkey = new Monkey();
//        Lion lion = new Lion();
//
//        Speak speak = new Speak();
//
//        monkey.accept(speak);    // Ooh oo aa aa!
//        lion.accept(speak);      // Roaaar!
//
//        7. strategy
//       int[] dataset = new int[]{1, 5, 4, 3, 2, 8};
//
//        Sorter sorter = new Sorter(new BubbleSortStrategy());
//        sorter.sort(dataset); // Output : Sorting using bubble sort
//
//        Sorter sorter1 = new Sorter(new QuickSortStrategy());
//        sorter1.sort(dataset); // Output : Sorting using quick sort

//        8.state
//        TextEditor editor = new TextEditor(new UpperCase());
//        editor.type("First line");
//      editor.setState(new LowerCase());
//        editor.type("Fourth line");
//        editor.type("Fifth line");

        //9.template
//        AndroidBuilder androidBuilder = new AndroidBuilder();
//        androidBuilder.build();
        try {Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/eshop_db_2?createDatabaseIfNotExist=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC", "me", "521027521027521027");
            UserMapper ur = new UserMapper(connection);


         User user = new User(11,"555","555");
         User user2 = new User(6,"777","777");

          System.out.println("done");

            ur.insert(user2);

//            ur.update(user1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


}
}
