package com.jmr.config;

import com.jmr.config.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 注册拦截器
 *
 * @author TTMY
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        this.loginInterceptor(registry);//未登录资源访问拦截
    }

    private void loginInterceptor(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/userlist", "/jiuye", "/job", "/findStudentBySex","/swagger-ui.html","/uploadpage")//拦截
                .excludePathPatterns( //释放
                        "/**/*.css",
                        "/**/*.js",
                        "/**/*.jpg",
                        "/**/*.png",
                        "/**/*.ico"
                )
        ;
    }

    private void adminInterceptor(InterceptorRegistry registry) {
    }
}