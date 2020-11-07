package servlets;

import services.ArticleService;
import services.Helper;
import services.UserProfileService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/advancedSearch")
public class AdvancedSearchServlet extends HttpServlet {
    ArticleService articleService;
    UserProfileService userProfileService;
    Helper helper;
    @Override
    public void init() throws ServletException {
        articleService = new ArticleService();
        userProfileService = new UserProfileService();
        helper = new Helper();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
