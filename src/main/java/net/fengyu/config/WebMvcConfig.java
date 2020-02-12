package net.fengyu.config;

import net.fengyu.interceptor.DemoInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.StandardCharsets;
import java.util.List;

//springboot 2.X后推荐实现WebMvcConfigurer接口？我不确定
@Configuration
//@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class WebMvcConfig extends WebMvcConfigurationSupport {


    @Autowired
    private DemoInterceptor demoInterceptor;

    //增加拦截器
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(demoInterceptor).addPathPatterns("/**");

        super.addInterceptors(registry);
    }

    //编码字符集问题
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 解决controller返回字符串中文乱码问题
        for (HttpMessageConverter<?> converter : converters) {
            if (converter instanceof StringHttpMessageConverter) {
                ((StringHttpMessageConverter)converter).setDefaultCharset(StandardCharsets.UTF_8);
            }
        }
    }

}
