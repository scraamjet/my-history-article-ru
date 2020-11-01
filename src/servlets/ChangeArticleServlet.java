package servlets;

import services.AddArticleService;
import services.Helper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/changeArticle")
public class ChangeArticleServlet extends HttpServlet {
    AddArticleService addArticleService;
    Helper helper;
    @Override
    public void init() throws ServletException {
        addArticleService = new AddArticleService();
        helper = new Helper();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        helper.render(request,response,"changeArticle.ftl",new HashMap<>());
    }
}
