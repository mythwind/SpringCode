package com.vincent.springbootdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @Auther: mythwind
 * @Date: 2019/01/29 09:44
 * @Description: 主要配置多视图实现的视图解析器相关bean实例,将该视图解析器注册到容器中
 * 其实关键点在于两个：
 * 1、配置order属性
 * 2、配置viewnames属性
 */
@Configuration
public class WebViewConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //registry.addViewController("/").setViewName("forward:/index");
        //registry.addViewController("/index").setViewName("index");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置不拦截的路径
        //InterceptorRegistration ir = registry.addInterceptor(authorizationInterceptor);
        //ir.excludePathPatterns("/picture/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    @Value("${spring.mvc.view.prefix}")
    private String prefix;
    @Value("${spring.mvc.view.suffix}")
    private String suffix;
    @Value("${spring.mvc.view.view-name}")
    private String viewNames;
    @Value("${spring.mvc.view.order}")
    private int order;

    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix(prefix);
        resolver.setSuffix(suffix);
        resolver.setViewNames(viewNames);
        resolver.setOrder(order);
        return resolver;
    }

}
