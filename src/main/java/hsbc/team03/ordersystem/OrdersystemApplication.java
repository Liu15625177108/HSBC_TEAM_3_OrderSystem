package hsbc.team03.ordersystem;

//import hsbc.team03.ordersystem.loginregister.WebSecurityConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ServletComponentScan
public class OrdersystemApplication /*extends AbstractAnnotationConfigDispatcherServletInitializer*/ {

    public static void main(String[] args) {
        SpringApplication.run(OrdersystemApplication.class, args);
    }
//
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        return new Class[]{WebSecurityConfig.class};
//    }
//
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return new Class[0];
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        return new String[0];
//    }
}
