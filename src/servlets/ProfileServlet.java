package servlets;

import models.User;
import models.UserProfile;
import repositories.UserProfileRepository;
import repositories.UserProfileRepositoryImpl;
import repositories.UserRepository;
import repositories.UserRepositoryJDBCImpl;
import services.Helper;
import services.UserProfileFinder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    private Helper helper;
    private UserProfileFinder userProfileFinder;
    @Override
    public void init() throws ServletException {
        helper = new Helper();
        userProfileFinder = new UserProfileFinder();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String userImagePath = userProfileFinder.findProfile(login).getImagePath();
        request.setAttribute("userImagePath",userImagePath);
        response.setContentType("text/html");
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("userImagePath",userImagePath);
        objectMap.put("login", login);
        helper.render(request, response, "profile.ftl", objectMap);
    }
}
