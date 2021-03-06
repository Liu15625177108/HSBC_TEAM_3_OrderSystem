package hsbc.team03.ordersystem.orderlistshow;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * Project:ordersystem
 * Package:hsbc.team03.ordersystem.orderList.show
 * Author:Alan Ruan
 * Date:2018-08-06 11:33
 * Description://
 */
@RunWith(SpringRunner.class)
@WebMvcTest(OrderShowController.class)
@Slf4j
public class OrderShowControllerTest {

    @MockBean
    private OrderService orderService;

    @Autowired
    private MockMvc mvc;

    private static final String ORDER_JSON_TEST = "{\"status\":200,\"msg\":\"已经是登录状态\",\"data\":{\"orderlist\":[{\"ConsumerName\":\"小锋\",\"ProductName\":\"龙卡VIP产品\",\"ProductNum\":1,\"Address\":\"华南师范大学\",\"OrderId\":\"A11\",\"OrderTime\":\"1970-01-01T00:00:02.018+0000\"},{\"ConsumerName\":\"小鑫\",\"ProductName\":\"黑金尊贵服务\",\"ProductNum\":2,\"Address\":\"SCNU\",\"OrderId\":\"B22\",\"OrderTime\":\"1970-01-01T00:00:00.036+0000\"}]}}";

    private static final String ORDER_JSON_TEST2 =
            "{\"ConsumerName\":\"小锋\",\"ProductName\":\"龙卡VIP产品\",\"ProductNum\":1,\"Address\":\"华南师范大学\",\"OrderId\":\"A11\",\"OrderTime\":\"1970-01-01T00:00:02.018+0000\"}";


    /**
     * @Method showAllOrder
     * @Description //Test
     * @Author Alan Ruan
     * @Date 2018/08/07 09:42:43
     * @Param []
     * @Return void
     */
    @Test
    public void showAllOrder() throws Exception{

        OrderInfo orderInfo1 = new OrderInfo();
        OrderInfo orderInfo2 = new OrderInfo();

        orderInfo1.setOrderId("A11");
        orderInfo1.setConsumerName("小锋");
        orderInfo1.setProductName("龙卡VIP产品");
        orderInfo1.setProductNum(1);
        orderInfo1.setAddress("华南师范大学");
        orderInfo1.setOrderTime(new Date(2018/1/1));

        orderInfo2.setOrderId("B22");
        orderInfo2.setConsumerName("小鑫");
        orderInfo2.setProductName("黑金尊贵服务");
        orderInfo2.setProductNum(2);
        orderInfo2.setAddress("SCNU");
        orderInfo2.setOrderTime(new Date(2018/8/7));


        List<OrderInfo> orderInfoList = new ArrayList<>();

        orderInfoList.add(orderInfo1);
        orderInfoList.add(orderInfo2);

        System.out.println(" ");
        System.out.println(orderInfoList.toString());
        System.out.println(" ");

        given(this.orderService.findAllOrder()).willReturn(orderInfoList);

        String result = this.mvc.perform(get("/order/list/show")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(ORDER_JSON_TEST))
                .andExpect(jsonPath("$.length()").value(3))
                .andReturn().getResponse().getContentAsString();

        log.info(result);
    }

    @Test
    public void findOrderById() throws Exception{

        OrderInfo orderInfo1 = new OrderInfo();

        orderInfo1.setOrderId("A11");
        orderInfo1.setConsumerName("小锋");
        orderInfo1.setProductName("龙卡VIP产品");
        orderInfo1.setProductNum(1);
        orderInfo1.setAddress("华南师范大学");
        orderInfo1.setOrderTime(new Date(2018/1/1));

        given(this.orderService.showOrderByUserId("A11")).willReturn(orderInfo1);

        String result = this.mvc.perform(get("/order/list/findOrder?orderId=A11").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(jsonPath("$.length()").value(6))
                .andExpect(content().string(ORDER_JSON_TEST2))
                .andReturn().getResponse().getContentAsString();
        log.info(result);
    }
}