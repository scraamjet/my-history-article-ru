package servlets;

import services.Helper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/options")
public class OptionsServlet extends HttpServlet {
    private Helper helper;
    @Override
    public void init() throws ServletException {
        helper = new Helper();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String exit = request.getParameter("exit");
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
        helper.render(request,response,"options.ftl",new HashMap<>());
    }
}
