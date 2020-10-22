package repositories;

import models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User> {
    List<User> findByLogin(String login);
    List<User> findALl();
}
