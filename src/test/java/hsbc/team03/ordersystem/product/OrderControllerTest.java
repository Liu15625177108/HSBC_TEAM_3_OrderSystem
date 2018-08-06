package hsbc.team03.ordersystem.product;


import hsbc.team03.ordersystem.product.commonsutils.CommonsUtils;
import hsbc.team03.ordersystem.product.result.ResultView;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=OrderController.class)
@WebMvcTest(OrderController.class)
@Slf4j
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
                "Chen","1111111111","岗顶",300);
        ResultView resultView=new ResultView<OrderInfo>(200,"success",orderInfo);
        given(this.orderService.toOrder()).willReturn(resultView);

        /**
         * to simulate the getOrderPrice() 
         */
        orderInfo.setProductNumber(2);
        orderInfo.setProductPrice(300);
        double orderPice=orderInfo.getProductNumber()*orderInfo.getProductPrice();
        given(this.orderService.getOrderPrice()).willReturn(orderPice);
        
        //
        /*ObjectMapper mapper=new ObjectMapper();
        String jsonSring="{\"orderid\":\"17e5372f-dfc1-41e7-b37a-a1edae87d299\"," +
                "\"productname\":\"信用卡\",\"productnumber\":2,\"username\":\"Chen\"," +
                "\"userphone\":\"1111111111\",\"useraddress\":\"岗顶\",\"productprice\":300.0}";*/
//        OrderInfo orderInfo1=mapper.readValue(jsonSring,OrderInfo.class);
        String result=this.mvc.perform(post("/order/toorder")
                .sessionAttr("userId","CommonsUtils.getUUID()")
                .param("orderId","CommonsUtils.getUUID()")
                .param("productNumber","2")
                .param("userName","Chen")
                .param("userPhone","11111111111")
               .param("userAddress","岗顶")
                .param("productPrice","300.0")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(3))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString(); //return response's value
        log.info(result);
    }
}