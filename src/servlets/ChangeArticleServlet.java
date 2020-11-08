package servlets;

import models.Article;
import models.User;
import models.UserProfile;
import services.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/changeArticle")
public class ChangeArticleServlet extends HttpServlet {
    private ArticleService articleService;
    private Helper helper;
    private UserProfileService userProfileService;
    private AddArticleService addArticleService;
    private AuthCheck authCheck;
    @Override
    public void init() throws ServletException {
        articleService = new ArticleService();
        helper = new Helper();
        userProfileService = new UserProfileService();
        addArticleService = new AddArticleService();
        authCheck = new AuthCheck();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession(false);
        String change = request.getParameter("change");
        String delete = request.getParameter("delete");
        User user = userProfileService.findUser((String) request.getSession(false).getAttribute("login"));
        String title = request.getParameter("title");
        String text = request.getParameter("text");
        Long id = (Long.parseLong(request.getParameter("id")));
        HashMap<String,Object> root = new HashMap<>();
        Article article = new Article(id,title,text,user.getId());
        if (change!=null&&change.equals("Change")) {
            if (addArticleService.checkTitleSeqLength(article)) {
                if (addArticleService.checkTextSeqLength(article)) {
                    articleService.updateArticle(article);
                    root.put("articleTitle", article.getTitle());
                    root.put("articleText", article.getText());
                    root.put("message", "Your article was successfully changed!");
                    helper.render(request, response, "changeArticle.ftl", root);
                } else {
                    root.put("message", "The text cannot be so shot. Minimal length: 30 characters!");
                    helper.render(request, response, "changeArticle.ftl", root);
                }
            } else {
                root.put("message", "The title cannot be so short. Minimal length: 4 characters!");
                helper.render(request, response, "changeArticle.ftl", root);
            }
        }
         if (delete.equals("Delete")){
            articleService.deleteArticle(article);
            httpSession.setAttribute("deleteArticleMessage","Your article was successfully deleted!");
            response.sendRedirect("http://localhost:8081/myArticle/myArticles");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> root = new HashMap<String, Object>();
        HttpSession httpSession = request.getSession(false);
        if(authCheck.sessionIsNull(httpSession)){
            root.put("message","Sign in again!");
            helper.render(request,response,"signIn.ftl",root);
        }
        else {
            Long id = (Long.parseLong(request.getParameter("id")));
            Article article = articleService.showMyArticle(id);
            root.put("articleTitle",article.getTitle());
            root.put("articleText",article.getText());
            helper.render(request,response,"changeArticle.ftl",root);
    }
}
}
