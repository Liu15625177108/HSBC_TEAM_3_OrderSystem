package hsbc_team_3.ordersystem;

import hsbc_team_3.ordersystem.product.controller.OrderController;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.slf4j.Logger;


@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
@AutoConfigureRestDocs
@SpringBootTest
public class OrdersystemApplicationTests {
    private MockMvc mvc;
    private static final Logger log= org.slf4j.LoggerFactory.getLogger(OrdersystemApplicationTests.class);
    @Test
    public void contextLoads() throws Exception {
        
        String result=this.mvc.perform(get("/getorderlist").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3))
                .andReturn().toString();
        log.info(result);
    }

}
