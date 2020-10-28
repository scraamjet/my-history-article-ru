package services;

import models.User;
import models.UserProfile;
import repositories.UserProfileRepository;
import repositories.UserProfileRepositoryImpl;
import repositories.UserRepositoryJDBCImpl;

public class CreateProfileService {
    private UserProfileRepositoryImpl userProfileRepository = new UserProfileRepositoryImpl();
    public void createProfile(User user){
        UserProfile userProfile = new UserProfile();
        userProfileRepository.save(userProfile);
        userProfileRepository.addUserProfileToUser(user,userProfile);
    }
}
