package services;

import models.User;
import models.UserProfile;
import repositories.UserProfileRepositoryImpl;

import javax.servlet.http.Part;
import java.io.File;
import java.util.Optional;

public class IconService {
    private FileSaver fileSaver;
    private UserProfileRepositoryImpl userProfileRepository = new UserProfileRepositoryImpl();
    private UserProfileService userProfileService = new UserProfileService();
    public void saveFile(Long id ,Part p,String directory) throws Exception {
        UserProfile userProfile;
        String basicPath = "C:\\Users\\user1\\IdeaProjects\\Sem_2course1semMyWebAPP\\webapp";
        fileSaver = new FileSaver(basicPath);
        Optional<UserProfile> userProfileOptional = userProfileRepository.findById(id);
        if(userProfileOptional.isPresent()) {
            userProfile = userProfileOptional.get();
        }
        else {
            throw new Exception("User Profile does not exist! id:"+ id);
        }
        Optional<String> imagePath=fileSaver.saveFile(p,directory);
        if (imagePath.isPresent()) {
            userProfile.setImagePath(imagePath.get());
            userProfileService.updateUserProfile(userProfile);
        }
        else {
            throw new Exception("ImagePath is does not exist!");
        }
    }
}
