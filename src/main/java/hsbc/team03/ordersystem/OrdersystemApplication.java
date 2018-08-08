package hsbc.team03.ordersystem;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;


@SpringBootApplication(
        scanBasePackages = {
                "hsbc.team03.ordersystem.toorder",
                "hsbc.team03.ordersystem.bankmanager",
                "hsbc.team03.ordersystem.productsshow",
                "hsbc.team03.ordersystem.displayproduct",
                /*"hsbc.team03.ordersystem.orderlistshow",*/
        })
public class OrdersystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrdersystemApplication.class, args);
    }
}
