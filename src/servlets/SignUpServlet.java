package servlets;

import models.UserProfile;
import services.Helper;
import services.SignUpService;
import services.UserProfileService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet
{
    private Helper helper;
    private SignUpService signUpService;
    @Override
    public void init() throws ServletException {
        helper = new Helper();
        signUpService = new SignUpService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        Map<String,Object> root = new HashMap<>();
        if(signUpService.checkPasswordInput(password)&&signUpService.checkLoginInput(login))
        {
            if(signUpService.isNotExist(login)) {
                signUpService.signUp(login,password);
                root.put("user", login);
                root.put("message","Account has been successfully created");
                helper.render(request, response, "profile.ftl", root);
        }
            else{
                root.put("message","This login already taken!");
                helper.render(request,response,"signUp.ftl",root);
            }
        }
        else
            {
                root.put("message","Login or password is empty!");
                helper.render(request,response,"signUp.ftl",root);
            }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        helper.render(request,response,"signUp.ftl",new HashMap<>());
    }
}
