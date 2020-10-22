package services;

import models.User;
import repositories.UserRepositoryJDBCImpl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


public class SignInService  {
    /*static ArrayList<User> userArrayList = new ArrayList<>();
    static{
        userArrayList.add(new User((long) 123,"u1","123"));
    }

     */
    private UserRepositoryJDBCImpl userRepositoryJDBC = new UserRepositoryJDBCImpl();
    public boolean signIn(String login,String password) {
        List<User> users = userRepositoryJDBC.findByLogin(login);
        if(users.size()==0) return false;
            else{
                if(users.get(0).getPassword().equals(password)){
                    return true;
                }
                else return false;
            }
        }
     public boolean isExist(String login){
        return userRepositoryJDBC.findByLogin(login)!=null;
     }
    public boolean checkLoginInput(String login) {
        return login != null;
    }
    public boolean checkPasswordInput(String password){
        return password!=null;
    }
    }
