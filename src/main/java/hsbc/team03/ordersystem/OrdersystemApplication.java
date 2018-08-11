package hsbc.team03.ordersystem;

import hsbc.team03.ordersystem.displayproduct.common.DataCheckTool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrdersystemApplication {

    @Bean
    public DataCheckTool  dataCheckTool(){
        return new DataCheckTool();
    }
    public static void main(String[] args) {
        SpringApplication.run(OrdersystemApplication.class, args);
    }
}
