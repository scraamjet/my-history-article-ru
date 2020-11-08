package servlets;

import models.User;
import models.UserProfile;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import services.AuthCheck;
import services.Helper;
import services.IconService;
import services.UserProfileService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ChangeAvatarServlet extends HttpServlet {
    private Helper helper;
    private UserProfileService userProfileService;
    private IconService iconService;
    @Override
    public void init() throws ServletException {

        helper = new Helper();
        iconService = new IconService();
        userProfileService = new UserProfileService();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession(false);
        HashMap<String,Object> root = new HashMap<>();
        String login  = (String) httpSession.getAttribute("login");
        UserProfile userProfile = userProfileService.findProfile(login);
        Part p = request.getPart("file1");
        try {
            iconService.saveFile(userProfile.getId(),p,"usersIcons");
            root.put("message","Your avatar was successfully changed!");
            helper.render(request,response,"changeAvatar.ftl",root);
        } catch (Exception e) {
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            helper.render(request,response,"changeAvatar.ftl",new HashMap<String, Object>());
    }
}
