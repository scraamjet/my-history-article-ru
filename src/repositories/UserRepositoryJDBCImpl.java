package repositories;

import models.User;
import models.UserProfile;
import singletons.ConnectionProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryJDBCImpl implements UserRepository {
    private Connection connection;
    public UserRepositoryJDBCImpl() {
        this.connection = ConnectionProvider.getConnection();
    }

    private static final String SQL_FIND_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String SQL_FIND_BY_LOGIN = "SELECT * FROM users WHERE login = ?";
    private static final String SQL_SAVE_USER = "INSERT INTO users(login,spw12)VALUES(?,?)";
    private static final String SQL_UPDATE_USER = "UPDATE user SET login WHERE id =? ";
    private static final String SQL_FIND_ALL_USERS = "SELECT * FROM users";
    private static final String SQL_DELETE_BY_ID = "DELETE FROM user WHERE id = ?";
    private static final String SQL_FIND_PROFILE = "SELECT * FROM users WHERE ";

    @Override
    public List<User> findByLogin(String pattern) {
        List<User> users = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_LOGIN)) {
            preparedStatement.setString(1,  pattern);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    users.add(userRowMapper.mapRow(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return users;
    }

    @Override
    public Optional<User> findById(Long id){
        User user = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_ID)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    user= userRowMapper.mapRow(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return Optional.ofNullable(user);
    }

    @Override
    public void save(User user) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SAVE_USER, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1,user.getLogin());
            preparedStatement.setString(2,user.getPassword());
            int updRows = preparedStatement.executeUpdate();
            if (updRows == 0) {
                throw new SQLException();
            }
            try (ResultSet set = preparedStatement.getGeneratedKeys();) {
                if (set.next()) {
                    user.setId(set.getLong(1));
                } else {
                    throw new SQLException();
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void update(User user) {
        try (PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_USER)) {
            statement.setString(1,user.getLogin());
            int updRows = statement.executeUpdate();

            if (updRows == 0) {

                throw new SQLException();
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
    @Override
    public void deleteById(Long id) {
        try (PreparedStatement statement = connection.prepareStatement(SQL_DELETE_BY_ID)) {
            statement.setLong(1,id);
            int updRows = statement.executeUpdate();
            if (updRows == 0) {
                throw new SQLException();
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public List<User> findALl() {
        User user;
        List<User> users = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL_FIND_ALL_USERS)) {
            while (resultSet.next()) {
                user = userRowMapper.mapRow(resultSet);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return users;
    }
    private RowMapper<User> userRowMapper = row -> {
        Long id = row.getLong("id");
        String login = row.getString("login");
        String spw12 = row.getString("spw12");
        Long profile_id = row.getLong("user_profile_id");
        return new User(id, login,spw12,profile_id);
    };
}
