package servlets;

import services.Helper;
import services.SignInService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {
    private Helper helper;
    private SignInService signInService;
    @Override
    public void init() throws ServletException
    {
        helper = new Helper();
        signInService = new SignInService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        boolean result = signInService.signIn(login, password);
        Map<String, Object> root = new HashMap<>();
        if (signInService.checkLoginInput(login) && signInService.checkPasswordInput(password)) {
            if (result) {
                Cookie cookie = new Cookie(login,"login");
                response.addCookie(cookie);
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("login", login);
                response.sendRedirect("http://localhost:8081/myArticle/profile");
            } else {
                root.put("message", "incorrect login or password");
                helper.render(request, response, "signIn.ftl", root);
            }
        }
        else {
            root.put("message","Login or password is so short! Minimal length of login: 3 characters, password: 7 characters");
            helper.render(request,response,"signIn.ftl",root);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        helper.render(request,response,"signIn.ftl",new HashMap<>());
    }

}
