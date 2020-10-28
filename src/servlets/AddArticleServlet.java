package servlets;

import models.Article;
import models.User;
import services.AddArticleService;
import services.Helper;
import services.UserProfileService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/addArticle")
public class AddArticleServlet extends HttpServlet {
    Helper helper;
    UserProfileService userProfileService;
    AddArticleService addArticleService;

    @Override
    public void init() throws ServletException {
        helper = new Helper();
        userProfileService = new UserProfileService();
        addArticleService = new AddArticleService();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = userProfileService.findUser((String) request.getSession(false).getAttribute("login"));
        String title = request.getParameter("title");
        String text = request.getParameter("text");
        String exit = request.getParameter("exit");
        String cancel = request.getParameter("cancel");

        Article article = new Article(title, text, user.getId());
        addArticleService.addArticle(article);

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
            response.sendRedirect("http://localhost:8081/myArticle/signIn");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        helper.render(request,response,"addArticle.ftl",new HashMap<String,Object>());
    }
}
