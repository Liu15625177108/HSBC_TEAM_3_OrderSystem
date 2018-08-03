package hsbc_team_3.ordersystem.product;


import hsbc_team_3.ordersystem.commonsutils.CommonsUtils;
import hsbc_team_3.ordersystem.result.ResultView;
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
        UserInfo userInfo=new UserInfo();
        userInfo.setPayPassword("123");
        String paypassword="123";
        given(this.userService.toValidatePayPassword(paypassword,userInfo)).willReturn(true);
        
        userInfo.setUserMoney(1000000.0);;
        double money=100000.0;
        given(this.userService.getMoney(userInfo)).willReturn(money);
        
        OrderInfo orderInfo=new OrderInfo();
        orderInfo.setOrderId(CommonsUtils.getUUID());
        orderInfo.setProductName("信用卡");
        orderInfo.setProductNumber(2);
        orderInfo.setUserAddress("岗顶");
        orderInfo.setUserName("Chen");
        orderInfo.setUserPhone("1111111111");
        orderInfo.setProductPrice(300);
        ResultView resultView=new ResultView<OrderInfo>(200,"成功",orderInfo);
        given(this.orderService.toOrder(orderInfo)).willReturn(resultView);

        orderInfo.setProductNumber(2);
        orderInfo.setProductPrice(300);
        double orderPice=orderInfo.getProductNumber()*orderInfo.getProductPrice();
        given(this.orderService.getOrderPrice(orderInfo)).willReturn(orderPice);
        
        this.mvc.perform(post("/order/toorder?userInfo=userInfo&orderInfo=orderInfo&payPassword=paypassword")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}