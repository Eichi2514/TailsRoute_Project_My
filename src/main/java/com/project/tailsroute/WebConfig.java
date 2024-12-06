package com.project.tailsroute;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    // @Override
    // public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // "/uploads/**" 경로를 "file:uploads/" 디렉토리로 매핑
    //    registry.addResourceHandler("/uploads/**")
    //            .addResourceLocations("file:uploads/");

    //    registry.addResourceHandler("/uploaded_videos/**")
    //            .addResourceLocations("file:uploaded_videos/");
    //}

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
       registry.addResourceHandler("/uploads/**") // 모든 하위 폴더와 파일 포함
               .addResourceLocations("file:/dockerProjects/tailsroute/source/TailsRoute_Project_My/uploads/");
         registry.addResourceHandler("/uploaded_videos/**")
                 .addResourceLocations("file:/dockerProjects/tailsroute/source/TailsRoute_Project_My/uploaded_videos/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 캐시 제어를 위한 인터셉터 추가
        registry.addInterceptor(new CacheControlInterceptor());
    }

    private static class CacheControlInterceptor implements HandlerInterceptor {
        @Override
        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, org.springframework.web.servlet.ModelAndView modelAndView) {
            // 캐싱 방지를 위한 HTTP 헤더 설정
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Expires", "0");
        }
    }
}
