package com.dgwl.interceptor;

import com.dgwl.eo.User;
import com.dgwl.model.HostHolder;
import com.dgwl.model.MySessionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author lee
 */
@Component
public class UserInfoInterceptor implements HandlerInterceptor {


    @Autowired
    HostHolder hostHolder;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final String sessionId = request.getParameter("sessionId");

        System.out.println(sessionId);
        if (MySessionContext.getSession(sessionId) != null) {
            User user = (User) MySessionContext.getSession(sessionId).getAttribute("user");
            hostHolder.setUser(user);
        }
        return true;
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (hostHolder.getUser() != null) {
            hostHolder.clear();
        }
    }
}
