package services;

import models.UserProfile;
import repositories.UserRepositoryJDBCImpl;


public class UserProfileFinder {
    private UserRepositoryJDBCImpl userRepositoryJDBC = new UserRepositoryJDBCImpl();

    public UserProfile findProfile(String login){
      return userRepositoryJDBC.findByLogin(login).get(0).getUserProfile();
    }
}
