package services;


import models.User;
import models.UserProfile;
import repositories.ArticleRepositoryImpl;
import repositories.UserProfileRepositoryImpl;
import repositories.UserRepositoryJDBCImpl;

import java.util.Optional;

public class UserProfileService {
    private UserRepositoryJDBCImpl userRepositoryJDBC = new UserRepositoryJDBCImpl();
    private UserProfileRepositoryImpl userProfileRepository = new UserProfileRepositoryImpl();
    private ArticleRepositoryImpl articleRepository = new ArticleRepositoryImpl();
    public UserProfile findProfile(String login){
        return userProfileRepository.findById(userRepositoryJDBC.findByLogin(login).get(0).getProfileID()).get();
    }
    public User findUser(String login){
        return userRepositoryJDBC.findByLogin(login).get(0);
    }
    public User findUser(Long id){ return userRepositoryJDBC.findById(id).get();}
    public int usersArticlesCount(Long userID){
        return articleRepository.countUsersArticles(userID);
    }
    public void updateUser(User user){
        userRepositoryJDBC.update(user);
    }
    public void updateUserProfile(UserProfile userProfile){
        userProfileRepository.update(userProfile);
    }
}
