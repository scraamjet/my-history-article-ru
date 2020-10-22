package repositories;

import models.User;
import models.UserProfile;

public interface UserProfileRepository extends CrudRepository<UserProfile> {
    void addUserProfileToUser(User user,UserProfile userProfile);
}
