package servlets;

import models.Article;
import models.UserProfile;
import services.ArticleService;
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
    Helper helper;
    ArticleService articleService;
    UserProfileService userProfileService;
    @Override
    public void init() throws ServletException {
        helper = new Helper();
        articleService = new ArticleService();
        userProfileService = new UserProfileService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String exit = request.getParameter("exit");
        if(exit.equals("Exit")){
            if(request.getSession(false)!=null){
                if(request.getSession(false).getAttribute("login") !=null){
                    HttpSession httpSession = request.getSession();
                    httpSession.removeAttribute("login");
                }
            }
            Cookie cookie = new Cookie("login","null");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            response.sendRedirect("/signIn");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        ArrayList<Article> articles = articleService.findSomeArticles(title);
        HashMap<String,Object> root = new HashMap<>();
        for(Article a:articles){
            a.setUserLogin(userProfileService.findUser(a.getUserID()).getLogin());
        }
        root.put("articles",articles);
        helper.render(request,response,"searchResult.ftl",root);
    }
}
