package hsbc.team03.ordersystem.bankmanager;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName ManagerInterceptorConfig
 * @Author:Jerry.Liu;
 * @Description://TODO
 * @Package hsbc.team03.ordersystem.bankmanager
 * @Date 2018/8/8 11:53
 */
@Configuration
public class ManagerInterceptorConfig extends WebMvcConfigurationSupport {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(new ManagerInterceptor());

    }
}
