package ru.geekbrains.proxy;

public class SecuredDoor {


    Door door;

    public SecuredDoor(Door door) {
        this.door = door;
    }


    public void open(String password) {

        if (authenticate(password)) {
            this.door.open();
        } else {
            System.out.println("Big no! It ain't possible.");
        }
    }


    public void close() {
        this.door.close();

    }

    public boolean authenticate(String password) {
        if (password == "$ecr@t") {
            return true;
        }
        return false;
    }
}

