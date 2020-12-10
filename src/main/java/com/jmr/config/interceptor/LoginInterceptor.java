package com.jmr.config.interceptor;

import com.jmr.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jmr.common.constant.Constants;
/**
 * 拦截未登录用户非法访问资源
 * 通过cookie 若cooki合法，则可以访问资源
 * 若不合法，则无法访问资源
 *
 * @auther TTMY
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired(required = false)
    private UserServiceImpl userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Cookie[] cookies = request.getCookies();
        boolean islogin = false;
        for(int i = 0;i<cookies.length;i++){
            Cookie cookie = cookies[i];
            if (cookie.getName().equals("username")&&userService.wasuserexist(cookie.getValue())){
                islogin=true;
            }
        }
        if (!islogin){
            response.sendRedirect(Constants.LOGIN_NULL);
            return false;
        }else {
            return true;
        }
    }

        @Override
        public void postHandle (HttpServletRequest request, HttpServletResponse response, Object handler,
                ModelAndView modelAndView) throws Exception {

        }

        @Override
        public void afterCompletion (HttpServletRequest request, HttpServletResponse response, Object handler, Exception
        ex)
            throws Exception {
        }
    }
