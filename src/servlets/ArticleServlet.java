package servlets;

import models.Article;
import models.User;
import models.UserProfile;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import services.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/article")
public class ArticleServlet extends HttpServlet {
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
        if (authCheck.sessionIsNull(httpSession)) {
            root.put("message", "Sign in again!");
            helper.render(request, response, "signIn.ftl", root);
        } else {
            String articleID = request.getParameter("id");
            Article article = articleService.showMyArticle((Long.parseLong(articleID)));
            User user = userProfileService.findUser(article.getUserID());
            UserProfile userProfile = userProfileService.findProfile(user.getLogin());
            root.put("article", article);
            root.put("userProfile",userProfile);
            root.put("user", user);
            helper.render(request, response, "article.ftl", root);
        }
    }
}
