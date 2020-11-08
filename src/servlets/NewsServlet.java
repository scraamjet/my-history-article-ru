package servlets;

import models.Article;
import services.ArticleService;
import services.Helper;
import services.NewsService;
import services.UserProfileService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/news")
public class NewsServlet extends HttpServlet {
    Helper helper;
    NewsService newsService;
    UserProfileService userProfileService;
    @Override
    public void init() throws ServletException {
        helper = new Helper();
        newsService = new NewsService();
        userProfileService = new UserProfileService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Article>articles = newsService.showNews();
        HashMap<String,Object> root = new HashMap<>();
        for(Article a:articles){
            a.setUserLogin(userProfileService.findUser(a.getUserID()).getLogin());
        }
        root.put("articles",articles);
        helper.render(request,response,"news.ftl",root);
    }
}
