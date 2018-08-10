/**
 * Copyright (C), 2018-2018, CLPS
 * FileName: AdapterConfig
 * Author:   ca
 * Date:     2018/8/2 22:05
 * Description:  Configuring Interceptors
 * History:
 * <author>          <time>          <version>          <desc>
 * Chen          2018/8/2 22:05     1.0               Configuring Interceptors
 */
package hsbc.team03.ordersystem.toorder.commonsutils;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.nio.charset.Charset;
import java.util.List;


/**
 * @description〈 Configuring Interceptors〉
 * @author Chen
 * @create 2018/8/2
 * @since 1.0.0
 */

@Configuration
public class AdapterConfig extends WebMvcConfigurationSupport{
    
    @Bean
    LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns  to add interceptor
        // excludePathPatterns  to exculde interceptor
//        registry.addInterceptor( loginInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/order/test1");
        super.addInterceptors(registry);
    }
    //to deal utf-8 start
    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(
                Charset.forName("UTF-8"));
        return converter;
    }

    @Override
    public void configureMessageConverters(
            List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(responseBodyConverter());
    }

    @Override
    public void configureContentNegotiation(
            ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }
    //end
}