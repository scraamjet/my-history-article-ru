package services;

import models.User;
import repositories.UserRepositoryJDBCImpl;


public class SignUpService {
    private UserRepositoryJDBCImpl userRepositoryJDBC = new UserRepositoryJDBCImpl();
    private CreateProfileService createProfileService = new CreateProfileService();
    public void signUp(String login, String password){
        User user = new User(login,password);
        userRepositoryJDBC.save(user);
        createProfileService.createProfile(user);
    }
    public boolean checkLoginInput(String login) {
        return login.length() != 0;
    }
    public boolean checkPasswordInput(String password){
        return password.length()!=0;
    }
    public boolean isNotExist(String login){
        return userRepositoryJDBC.findByLogin(login).size()==0;
    }
}
