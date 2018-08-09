package hsbc.team03.ordersystem;


import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;



@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//        scanBasePackages = {
//                "hsbc.team03.ordersystem.toorder",
//                "hsbc.team03.ordersystem.bankmanager",
//                "hsbc.team03.ordersystem.productsshow",
//                "hsbc.team03.ordersystem.displayproduct",
//                /*"hsbc.team03.ordersystem.orderlistshow",*/
//        })

//public class OrdersystemApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(OrdersystemApplication.class, args);
//    }
//}
public class OrdersystemApplication extends SpringBootServletInitializer {

        public static void main(String[] args) {
        SpringApplication.run(OrdersystemApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(OrdersystemApplication.class);
    }
}