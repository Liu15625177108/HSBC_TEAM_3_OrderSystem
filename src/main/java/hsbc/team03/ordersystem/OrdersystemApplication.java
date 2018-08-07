package hsbc.team03.ordersystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {
                "hsbc.team03.ordersystem.product",
                "hsbc.team03.ordersystem.bankmanager",
                "hsbc.team03.ordersystem.productsshow",
                "hsbc.team03.ordersystem.loginregister",
                "hsbc.team03.ordersystem.displayproduct",
                /*"hsbc.team03.ordersystem.orderlistshow",*/
        })
public class OrdersystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrdersystemApplication.class, args);
    }
}
