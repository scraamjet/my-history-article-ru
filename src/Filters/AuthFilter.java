package Filters;

import services.Helper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

import static java.util.Objects.nonNull;

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
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession httpSession = req.getSession();
        if(httpSession.getAttribute("login").toString().length() == 0){
            helper.render(req,resp,"signIn.ftl",new HashMap<String, Object>());
        }
    }

    @Override
    public void destroy() {

    }
}
