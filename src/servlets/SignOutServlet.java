package servlets;

import services.Helper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/signOut")
public class SignOutServlet extends HttpServlet {
    private Helper helper;
    @Override
    public void init() throws ServletException {
        helper = new Helper();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        httpSession.removeAttribute("login");
        httpSession.removeAttribute("password");
        helper.render(req,resp,"signIn.ftl",new HashMap<String, Object>());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        httpSession.removeAttribute("login");
        httpSession.removeAttribute("password");
        helper.render(req,resp,"signIn.ftl",new HashMap<String, Object>());
    }
}
