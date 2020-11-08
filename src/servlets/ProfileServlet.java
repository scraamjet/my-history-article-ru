package servlets;

import Filters.AuthFilter;
import models.User;
import models.UserProfile;
import services.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    private Helper helper;

    private UserProfileService userProfileService;
    private AddArticleService addArticleService;
    private SearchService searchService;
    private AuthCheck authCheck;

    @Override
    public void init() throws ServletException {
        helper = new Helper();
        userProfileService = new UserProfileService();
        searchService = new SearchService();
        authCheck = new AuthCheck();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            HashMap<String, Object> root = new HashMap<String, Object>();
            HttpSession httpSession = request.getSession(false);
            if(authCheck.sessionIsNull(httpSession)){
                root.put("message","Sign in again!");
                helper.render(request,response,"signIn.ftl",root);
            }
            else {
                String login = (String) request.getSession(false).getAttribute("login");
                User user = userProfileService.findUser(login);
                UserProfile userProfile = userProfileService.findProfile(login);
                String icon = userProfile.getImagePath();
                int articlesCount = userProfileService.usersArticlesCount(user.getId());
                root.put("login", login);
                root.put("icon", icon);
                root.put("articlesCount", articlesCount);
                helper.render(request, response, "profile.ftl", root);
            }
    }
}
