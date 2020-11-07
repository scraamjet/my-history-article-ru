package servlets;

import Filters.AuthFilter;
import models.User;
import models.UserProfile;
import services.AddArticleService;
import services.Helper;
import services.SearchService;
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
    private AddArticleService addArticleService;
    private SearchService searchService;
    @Override
    public void init() throws ServletException {
        helper = new Helper();
        userProfileService = new UserProfileService();
        searchService = new SearchService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String exit = request.getParameter("exit");
        String search = request.getParameter("search");
        HashMap<String,Object> root = new HashMap<>();
        if(searchService.checkSearchTitleInput(search)){
            response.sendRedirect("http://localhost:8081/myArticle/search?title=search");
        }else {
            root.put("message","You use forbidden characters: @,$,#,%,+,=,^{,},_");
            helper.render(request,response,"profile.ftl",root);
        }
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
        String login = (String) request.getSession(false).getAttribute("login");
        User user = userProfileService.findUser(login);
        UserProfile userProfile = userProfileService.findProfile(login);
        double articleRATE = userProfile.getArticleAverageRATE();
        String icon = userProfile.getImagePath();
        int articlesCount = userProfileService.usersArticlesCount(user.getId());
        HashMap<String, Object> root = new HashMap<String,Object>();
        root.put("login",login);
        root.put("articleRATE",articleRATE);
        root.put("icon",icon);
        root.put("articlesCount",articlesCount);
        helper.render(request,response,"profile.ftl",root);
    }
}
