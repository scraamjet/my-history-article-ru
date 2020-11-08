package Filters;

import services.Helper;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@WebFilter(urlPatterns = {"/profile","/addArticle","/myArticles","/article","/advancedSearch"},filterName = "auth")
public class AuthFilter implements Filter {

    private Helper helper;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    helper = new Helper();
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession httpSession = request.getSession(false);

        Cookie [] cookie = request.getCookies();
        String userCookie = null;
        if (cookie != null) {
            userCookie = getCookie(cookie);
        }

        if((httpSession == null||httpSession.getAttribute("login") == null)) {
            if (userCookie == null) {
                response.sendRedirect("http://localhost:8081/myArticle/signIn");
            }

        }
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }


     private static String getCookie(Cookie[] cookies){
        String str = null;
        for (Cookie c : cookies) {
            if (c.getName().equals("login")) {
                str = c.getValue();
            }
        }
        return str;
    }
}
