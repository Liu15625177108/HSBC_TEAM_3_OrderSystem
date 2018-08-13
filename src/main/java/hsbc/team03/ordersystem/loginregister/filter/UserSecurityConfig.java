package hsbc.team03.ordersystem.loginregister.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Package: hsbc.team03.ordersystem.loginregister
 * @Program: ordersystem
 * @Description: a configuration to user login
 * @Author: Jeff.Li
 * @Created: 2018年08月07日 16:38:09
 **/
@Configuration
public class UserSecurityConfig extends WebMvcConfigurationSupport {

//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        InterceptorRegistration registry1 = registry.addInterceptor(new LoginInterceptor());
//        registry1.addPathPatterns("/**");
//        registry1.excludePathPatterns("/user/**");
//        registry1.excludePathPatterns("/error");
//        registry1.excludePathPatterns("/manager/login");
//        registry1.excludePathPatterns("/user/get/products");
//        super.addInterceptors(registry);
//    }

}
