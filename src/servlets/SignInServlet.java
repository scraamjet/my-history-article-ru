package servlets;

import services.Helper;
import services.SignInService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        Map<String, Object> root = new HashMap<>();
        if (signInService.checkLoginInput(login) && signInService.checkPasswordInput(password)) {
            if (result) {
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("login", login);
                root.put("login", login);
                helper.render(request, response, "profile.ftl", root);
            } else {
                root.put("message", "incorrect login or password");
                helper.render(request, response, "signIn.ftl", root);
            }
        }
        else {
            root.put("message","login or password input is empty!");
            helper.render(request,response,"signIn.ftl",root);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        helper.render(request,response,"signIn.ftl",new HashMap<>());
    }

}
