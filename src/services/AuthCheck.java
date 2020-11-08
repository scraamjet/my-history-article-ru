package services;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

public class AuthCheck {
    public boolean sessionIsNull(HttpSession httpSession) {
        return ((httpSession == null||httpSession.getAttribute("login") == null));
    }
}
