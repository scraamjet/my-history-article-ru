package servlets;

import models.Article;
import models.UserProfile;
import services.ArticleService;
import services.AuthCheck;
import services.Helper;
import services.UserProfileService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/searchResult")
public class SearchResultServlet extends HttpServlet {
    private Helper helper;
    private ArticleService articleService;
    private UserProfileService userProfileService;
    private AuthCheck authCheck;

    @Override
    public void init() throws ServletException {
        helper = new Helper();
        articleService = new ArticleService();
        userProfileService = new UserProfileService();
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
            String title = request.getParameter("title");
            ArrayList<Article> articles = articleService.findSomeArticles(title);
            for (Article a : articles) {
                a.setUserLogin(userProfileService.findUser(a.getUserID()).getLogin());
            }
            root.put("articles", articles);
            helper.render(request, response, "searchResult.ftl", root);
        }
    }
}
