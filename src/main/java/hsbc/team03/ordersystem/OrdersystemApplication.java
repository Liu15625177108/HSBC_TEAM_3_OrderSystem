package hsbc.team03.ordersystem;


import hsbc.team03.ordersystem.toorder.product.OrdersController;
import hsbc.team03.ordersystem.toorder.result.ResultViewService;
import hsbc.team03.ordersystem.toorder.result.ResultViewServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//exclude = DataSourceAutoConfiguration.class
@SpringBootApplication()
/**open transaction*/
@EnableTransactionManagement
public class OrdersystemApplication   {

    public static void main(String[] args) {
        SpringApplication.run(OrdersystemApplication.class, args);
        
    }
}
