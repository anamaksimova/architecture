package ru.geekbrains;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}