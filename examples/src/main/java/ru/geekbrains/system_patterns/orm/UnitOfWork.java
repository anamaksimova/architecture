package ru.geekbrains.system_patterns.orm;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UnitOfWork {
    private final UserMapper userMapper;

    private final List<User> newUsers = new ArrayList<>();
    private final List<User> updateUsers = new ArrayList<>();
    private final List<User> deleteUsers = new ArrayList<>();

    public UnitOfWork(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void registerNew(User user) {
        this.newUsers.add(user);
    }

    public void registerUpdate(User user) {
        this.updateUsers.add(user);
    }

    public void registerDelete(User user) {
        this.deleteUsers.add(user);
    }

    public void commit() {
        try {
            insert();  update();
            delete();
            clear();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private void update() throws SQLException {
        for (User updateUser : this.updateUsers) {
            userMapper.update(updateUser);
        }
    }

    private void insert() throws SQLException {
        for (User newUser : this.newUsers) {
            userMapper.insert(newUser);
        }
    }

    private void delete() throws SQLException {
        for (User deleteUser : this.deleteUsers) {
            userMapper.delete(deleteUser);
        }
    }

    private void clear() {
        this.newUsers.clear();
        this.updateUsers.clear();
        this.deleteUsers.clear();
    }
}
