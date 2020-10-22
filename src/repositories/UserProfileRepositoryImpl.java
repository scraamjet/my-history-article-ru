package repositories;

import models.Article;
import models.User;
import models.UserProfile;
import singletons.ConnectionProvider;

import java.io.IOException;
import java.sql.*;
import java.util.Optional;
import java.util.regex.Pattern;

public class UserProfileRepositoryImpl implements UserProfileRepository {
    private Connection connection;
    private static final String SQL_FIND_BY_ID = "SELECT * FROM users_profiles WHERE id = ?";
    private static final String SQL_SAVE = "INSERT INTO users_profiles(profile_image)VALUES(?)";
    private static final String SQL_PROFILE_TO_USER = "UPDATE users SET user_profile_id = ? WHERE id = ?";
    private static final String SQL_UPDATE = "UPDATE users_profiles SET profile_image";

    public UserProfileRepositoryImpl() {
        this.connection = ConnectionProvider.getConnection();
    }

    @Override
    public void addUserProfileToUser(User user,UserProfile userProfile) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_PROFILE_TO_USER, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1,userProfile.getId());
            preparedStatement.setLong(2,user.getId());
            int updRows = preparedStatement.executeUpdate();
            if (updRows == 0) {
                //Если ничего не было изменено, значит возникла ошибка
                //Возбуждаем соответсвующее исключений
                throw new SQLException();
            }
            try (ResultSet set = preparedStatement.getGeneratedKeys()) {
                if (set.next()) {
                    userProfile.setId(set.getLong(1));
                } else {
                    throw new SQLException();
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Optional<UserProfile> findById(Long id) {
        UserProfile userProfile = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_ID)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    userProfile = userProfileRowMapper.mapRow(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return Optional.ofNullable(userProfile);
    }

    @Override
    public void save(UserProfile userProfile) {

            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SAVE, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setBytes(1,userProfile.startImagePath());
                int updRows = preparedStatement.executeUpdate();
                if (updRows == 0) {
                    //Если ничего не было изменено, значит возникла ошибка
                    //Возбуждаем соответсвующее исключений
                    throw new SQLException();
                }
                //Достаём созданное Id пользователя
                try (ResultSet set = preparedStatement.getGeneratedKeys()) {
                    //Если id  существет,обновляем его у подели.
                    if (set.next()) {
                        userProfile.setId(set.getLong(1));
                    } else {
                        //Модель сохранилась но не удаётся получить сгенерированный id
                        //Возбуждаем соответвующее исключение
                        throw new SQLException();
                    }
                }
            } catch (SQLException | IOException e) {
                throw new IllegalStateException(e);
            }
    }

    @Override
    public void update(UserProfile userProfile) {

    }

    @Override
    public void deleteById(Long id) {

    }
    private RowMapper<UserProfile> userProfileRowMapper = row -> {
        Long id = row.getLong("id");
        String imagePath = row.getString("image");
        return new UserProfile(id, imagePath);
    };
}
