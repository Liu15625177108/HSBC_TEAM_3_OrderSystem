package hsbc.team03.ordersystem.product;


import com.fasterxml.jackson.databind.ObjectMapper;
import hsbc.team03.ordersystem.commonsutils.CommonsUtils;
import hsbc.team03.ordersystem.result.ResultView;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.testng.Assert.*;
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

        UserInfo userInfo=new UserInfo(CommonsUtils.getUUID(),"Chen",
                100000,"123","11111111111",
                "岗顶");
        ProductInfo productInfo=new ProductInfo(CommonsUtils.getUUID(),3,
                100,"信用卡");
        OrderInfo orderInfo=new OrderInfo(CommonsUtils.getUUID(),
                productInfo.getProductName(),productInfo.getProdcutNumber(),
                userInfo.getUserName(),userInfo.getUserPhone(),
                userInfo.getUserAddress(),productInfo.getProdcutPrice());
        ResultView resultView=new ResultView<OrderInfo>(200,"success",orderInfo);
        
        
        given(this.userService.toValidatePayPassword(Mockito.any(UserInfo.class),eq("123"))).willReturn(true);
        given(this.orderService.toOrder(Mockito.any(ProductInfo.class),Mockito.any(UserInfo.class))).willReturn(resultView);
        given(this.orderService.getOrderPrice(eq(3),eq(100.0))).willReturn(300.0);
        
        
        String jsonString="{\"productid\":\"17e5372f-dfc1-41e7-b37a-a1edae87d299\"," +
                "\"prodcutnumber\":3,\"prodcutprice\":100.0,\"productname\":\"信用卡\"}";

        
        String result =this.mvc.perform(post("/order/toorder")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString)
                .sessionAttr("userInfo",userInfo)
                .param("payPassword","123"))
                .andExpect(jsonPath("$.length()").value(3))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString(); //return response's value
        log.info(result);
    }
}