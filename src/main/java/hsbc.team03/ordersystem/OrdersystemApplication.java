package hsbc.team03.ordersystem;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;


@SpringBootApplication
public class OrdersystemApplication {
    //to deal utf-8
    public static void main(String[] args) {
        SpringApplication.run(OrdersystemApplication.class, args);

       
       
    }
}
