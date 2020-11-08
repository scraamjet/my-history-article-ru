package repositories;

import models.Article;
import singletons.ConnectionProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class ArticleRepositoryImpl implements ArticleRepository{
    private Connection connection;
    private static final String SQL_FIND_ALL_BY_TITLE = "SELECT * FROM articles WHERE title = ?";
    private static final String SQL_FIND_BY_ID = "SELECT * FROM articles WHERE id = ?";
    private static final String SQL_SAVE_ARTICLE = "INSERT INTO articles (title,text,owner_id)VALUES(?,?,?)";
    private static final String SQL_UPDATE_ARTICLE = "UPDATE articles SET title = ?,text = ?WHERE id = ? ";
    private static final String SQL_FIND_ALL_BY_USER_ID = "SELECT * FROM articles WHERE owner_id = ?";
    private static final String SQL_DELETE_BY_ID = "DELETE FROM articles WHERE id = ?";
    private static final String SQL_NEWS = "SELECT * FROM articles WHERE date = CURRENT_DATE;";
    //private static final String SQL_COUNT_USERS_ARTICLES = "SELECT COUNT(*) as count FROM articles WHERE owner_id = ?";

    public ArticleRepositoryImpl() {
        this.connection = ConnectionProvider.getConnection();
    }

    public int countUsersArticles(Long userID){
        int result = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL_BY_USER_ID)) {
            preparedStatement.setLong(1,userID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    result++;
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return result;
    }
    @Override
    public List<Article> findAllByTitle(String title) {
        List<Article> articles = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL_BY_TITLE)) {
            preparedStatement.setString(1,  title);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    articles.add(articleRowMapper.mapRow(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return articles;
    }

    @Override
    public List<Article> findAllByUserID(Long userID) {
        List<Article> articles = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL_BY_USER_ID)) {
            preparedStatement.setLong(1,userID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    articles.add(articleRowMapper.mapRow(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return articles;
    }

    @Override
    public List<Article> findNews() {
        List<Article> articles = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_NEWS)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    articles.add(articleRowMapper.mapRow(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return articles;
    }

    @Override
    public Optional<Article> findById(Long id) {
        Article article = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_ID)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    article = articleRowMapper.mapRow(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return Optional.ofNullable(article);
    }

    @Override
    public void save(Article article) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SAVE_ARTICLE, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1,article.getTitle());
            preparedStatement.setString(2,article.getText());
            preparedStatement.setLong(3,article.getUserID());
            int updRows = preparedStatement.executeUpdate();
            if (updRows == 0) {
                throw new SQLException();
            }
            try (ResultSet set = preparedStatement.getGeneratedKeys()) {
                if (set.next()) {
                    article.setId(set.getLong(1));
                } else {
                    throw new SQLException();
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void update(Article article) {
        try (PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_ARTICLE)) {
            statement.setString(1,article.getTitle());
            statement.setString(2,article.getText());
            statement.setLong(3,article.getId());
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
    private RowMapper<Article> articleRowMapper = row -> {
        Long id = row.getLong("id");
        String title = row.getString("title");
        String text = row.getString("text");
        Long userID = row.getLong("owner_id");
        Date date = row.getDate("date");
        return new Article(id,title,text,userID,date);
    };
}
