package servlets;

import Filters.AuthFilter;
import models.User;
import models.UserProfile;
import services.Helper;
import services.UserProfileService;

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
    @Override
    public void init() throws ServletException {
        helper = new Helper();
        userProfileService = new UserProfileService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String exit = request.getParameter("exit");
        String myArticles = request.getParameter("myArticles");
        String news = request.getParameter("news");
        String options = request.getParameter("options");
        String addArticle = request.getParameter("addArticle");
        if (exit.equals("Exit")) {
            if (request.getSession(false) != null) {
                if (request.getSession(false).getAttribute("login") != null) {
                    HttpSession httpSession = request.getSession();
                    httpSession.removeAttribute("login");
                }
            }
            Cookie cookie = new Cookie("login", "null");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            response.sendRedirect("http://localhost:8081/myArticle/signIn");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String login = (String) request.getSession(false).getAttribute("login");
        User user = userProfileService.findUser(login);
        UserProfile userProfile = userProfileService.findProfile(login);
        Double averageRATE = userProfile.getArticleAverageRATE();
        String imagePATH = userProfile.getImagePath();
        HashMap<String,Object> root = new HashMap<>();
        root.put("RATE",averageRATE);
        root.put("image",imagePATH);
        root.put("login",login);
         */

        helper.render(request,response,"profile.ftl",new HashMap<>());
    }
}
