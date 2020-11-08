package servlets;

import models.Article;
import models.User;
import models.UserProfile;
import services.AddArticleService;
import services.ArticleService;
import services.Helper;
import services.UserProfileService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/changeArticle")
public class ChangeArticleServlet extends HttpServlet {
    ArticleService articleService;
    Helper helper;
    UserProfileService userProfileService;
    AddArticleService addArticleService;
    @Override
    public void init() throws ServletException {
        articleService = new ArticleService();
        helper = new Helper();
        userProfileService = new UserProfileService();
        addArticleService = new AddArticleService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = userProfileService.findUser((String) request.getSession(false).getAttribute("login"));
        String title = request.getParameter("title");
        String text = request.getParameter("text");
        String exit = request.getParameter("exit");
        HashMap<String,Object> root = new HashMap<>();
        Article article = new Article(title, text, user.getId());

        if(addArticleService.checkTitleSeqLength(article)) {
            if (addArticleService.checkTextSeqLength(article)) {
                articleService.updateArticle(article);
                root.put("message","Your article was successfully saved!");
                helper.render(request,response,"addArticle.ftl",root);
            }
            else {
                root.put("message","The text cannot be so shot. Minimal length: 30 characters!");
                helper.render(request,response,"addArticle.ftl",root);
            }
        }
        else {
            root.put("message","The title cannot be so short. Minimal length: 4 characters!");
            helper.render(request,response,"addArticle.ftl",root);
        }
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
        helper.render(request,response,"changeArticle.ftl",new HashMap<>());
    }
}
