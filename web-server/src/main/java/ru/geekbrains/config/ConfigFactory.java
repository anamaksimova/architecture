package ru.geekbrains.config;

public class ConfigFactory {
    public static Configuration create(String[] args) {
        if (args.length == 2) {
            return new ConfigFromCli(args);
        } else {
            return new ConfigFromFile("./../../../server.properties");
        }
    }
}
