package servlets;

import models.User;
import services.ArticleService;
import services.Helper;
import services.UserProfileService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/myArticles")
public class MyArticlesServlet extends HttpServlet {
    Helper helper;
    UserProfileService userProfileService;
    ArticleService articleService;
    @Override
    public void init() throws ServletException {
        helper = new Helper();
        userProfileService = new UserProfileService();
        articleService = new ArticleService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = (String) request.getSession(false).getAttribute("login");
        User user =  userProfileService.findUser(login);

        HashMap<String,Object> root = new HashMap<>();
        helper.render(request,response,"myArticles",root);
    }
}
