package ru.geekbrains.system_patterns.orm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserMapper {
    private final Connection conn;

    private final PreparedStatement selectUser;
    private final PreparedStatement deleteUser;
    private final PreparedStatement insertUser;
    private final PreparedStatement updateUser;
    private final Map<Long, User> identityMap = new HashMap<>();

    public UserMapper(Connection conn) {
        this.conn = conn;
        try {
            this.selectUser = conn.prepareStatement("select id, username, password from users where id = ?");
            this.deleteUser = conn.prepareStatement("delete from from users where id = ?");
            this.insertUser = conn.prepareStatement("insert into users (username, password) values(?,?)");
            this.updateUser = conn.prepareStatement("update users set username=? , password=? where id=?" );
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public Optional<User> findById(long id) {
        User user = identityMap.get(id);
        if (user != null) {
            return Optional.of(user);
        }
        try {
            selectUser.setLong(1, id);
            ResultSet rs = selectUser.executeQuery();
            if (rs.next()) {
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
                identityMap.put(id, user);
                return Optional.of(user);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return Optional.empty();
    }

    public void update(User user) throws SQLException {
        identityMap.put((long) user.getId(), user);
        updateUser.setString(1, user.getLogin());
        updateUser.setString( 2, user.getPassword());
        updateUser.setLong(3, user.getId());
        ResultSet rs = updateUser.executeQuery();
    }

    public void insert(User user) throws SQLException {

        insertUser.setString(1, user.getLogin());
        insertUser.setString( 2, user.getPassword());
        ResultSet rs = insertUser.executeQuery();
    }

    public void delete(User user) throws SQLException {
       identityMap.remove(user.getId(), user);
        deleteUser.setLong(1, user.getId());
        ResultSet rs = deleteUser.executeQuery();

    }
}
