package servlets;

import models.Article;
import models.User;
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

@WebServlet("/myArticles")
public class MyArticlesServlet extends HttpServlet {
    private Helper helper;
    private UserProfileService userProfileService;
    private ArticleService articleService;
    private AuthCheck authCheck;

    @Override
    public void init() throws ServletException {
        helper = new Helper();
        userProfileService = new UserProfileService();
        articleService = new ArticleService();
        authCheck = new AuthCheck();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> root = new HashMap<String, Object>();
        HttpSession httpSession = request.getSession(false);
        if (authCheck.sessionIsNull(httpSession)) {
            root.put("message", "Sign in again!");
            helper.render(request, response, "signIn.ftl", root);
        } else {
            String login = (String) request.getSession(false).getAttribute("login");
            User user = userProfileService.findUser(login);
            ArrayList<Article> articles = articleService.findMyArticles(user.getId());
            if(httpSession.getAttribute("deleteArticleMessage")!=null){
                root.put("message",httpSession.getAttribute("deleteArticleMessage"));
            }
            root.put("articles", articles);
            root.put("login", login);
            helper.render(request, response, "myArticles.ftl", root);
        }
    }
}
