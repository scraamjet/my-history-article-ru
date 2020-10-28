package services;


import models.User;
import models.UserProfile;
import repositories.UserProfileRepositoryImpl;
import repositories.UserRepositoryJDBCImpl;

import java.util.Optional;

public class UserProfileService {
    private UserRepositoryJDBCImpl userRepositoryJDBC = new UserRepositoryJDBCImpl();
    private UserProfileRepositoryImpl userProfileRepository = new UserProfileRepositoryImpl();
    public UserProfile findProfile(String login){
        return userProfileRepository.findById(userRepositoryJDBC.findByLogin(login).get(0).getProfileID()).get();
    }
    public User findUser(String login){
        return userRepositoryJDBC.findByLogin(login).get(0);
    }
}
