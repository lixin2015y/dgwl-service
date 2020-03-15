package com.dgwl.config;

import com.dgwl.interceptor.PassportInterceptor;
import com.dgwl.interceptor.UserInfoInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lee
 */
@Component
public class WebConfiguration implements WebMvcConfigurer {


    @Autowired
    UserInfoInterceptor userInfoInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {

        List<String> excludePatterns = new ArrayList();
        excludePatterns.add("/user/login");
        registry.addInterceptor(userInfoInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(excludePatterns);

    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }


}
