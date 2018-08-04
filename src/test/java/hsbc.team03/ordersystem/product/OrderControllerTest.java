package hsbc.team03.ordersystem.product;


import hsbc.team03.ordersystem.commonsutils.CommonsUtils;
import hsbc.team03.ordersystem.result.ResultView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.testng.Assert.*;
@RunWith(SpringRunner.class)
@ContextConfiguration(classes=OrderController.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private OrderService orderService;
    @MockBean
    private UserService userService;
    @Test
    public void testToOrder() throws Exception {
        /**
         * to simulate the toValidatePayPassword() 
         */
        UserInfo userInfo=new UserInfo(CommonsUtils.getUUID(),"Chen",
                100000,"123");
        String paypassword="123";
        given(this.userService.toValidatePayPassword()).willReturn(true);

        /**
         * to simulate the getMoney() 
         */
        double money=100000.0;
        given(this.userService.getMoney()).willReturn(money);
        
        OrderInfo orderInfo=new OrderInfo(CommonsUtils.getUUID(),"信用卡",2,
                "岗顶","Chen","1111111111",300);
        ResultView resultView=new ResultView<OrderInfo>(200,"成功",orderInfo);
        given(this.orderService.toOrder()).willReturn(resultView);

        /**
         * to simulate the getOrderPrice() 
         */
        orderInfo.setProductNumber(2);
        orderInfo.setProductPrice(300);
        double orderPice=orderInfo.getProductNumber()*orderInfo.getProductPrice();
        given(this.orderService.getOrderPrice()).willReturn(orderPice);
        

        this.mvc.perform(post("/order/toorder")

                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(3))
                .andExpect(status().isOk());
    }
}