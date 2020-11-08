package servlets;

import services.ArticleService;
import services.Helper;
import services.SearchService;
import services.UserProfileService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/advancedSearch")
public class AdvancedSearchServlet extends HttpServlet {
    private ArticleService articleService;
    private UserProfileService userProfileService;
    private Helper helper;
    private SearchService searchService;
    @Override
    public void init() throws ServletException {
        articleService = new ArticleService();
        userProfileService = new UserProfileService();
        helper = new Helper();
        searchService = new SearchService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String,Object> root = new HashMap<>();
        String title = request.getParameter("title");
        if(title.length()>=4) {
            response.sendRedirect("http://localhost:8081/myArticle/searchResult?title=" + title);
        }
        else{
            root.put("message","Title can be so short! Minimal count of characters: 4");
            helper.render(request,response,"advancedSearch.ftl",root);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String,Object> root = new HashMap<>();
        helper.render(request,response,"advancedSearch.ftl",root);
    }
}
