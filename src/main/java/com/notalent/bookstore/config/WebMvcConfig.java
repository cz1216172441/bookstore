package com.notalent.bookstore.config;

import com.notalent.bookstore.interceptor.AuthenticationInterceptor;
import com.notalent.bookstore.util.FileUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns("/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 静态资源访问
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        // 用户头像访问
        registry.addResourceHandler("/static/upload/user/**")
                .addResourceLocations("file:" + FileUtils.FILE_URL + FileUtils.USER_UPLOAD_URL);
        // 图书图片访问
        registry.addResourceHandler("/static/upload/book/**")
                .addResourceLocations("file:" + FileUtils.FILE_URL + FileUtils.BOOK_UPLOAD_URL);
    }

    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }

}
