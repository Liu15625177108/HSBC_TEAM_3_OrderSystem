package hsbc.team03.ordersystem;


import hsbc.team03.ordersystem.toorder.product.OrdersController;
import hsbc.team03.ordersystem.toorder.result.ResultViewService;
import hsbc.team03.ordersystem.toorder.result.ResultViewServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication

public class OrdersystemApplication   {

    public static void main(String[] args) {
        SpringApplication.run(OrdersystemApplication.class, args);
        
    }
}
