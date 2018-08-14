package hsbc.team03.ordersystem;

//import hsbc.team03.ordersystem.loginregister.security.WebSecurityConfig;

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
}
