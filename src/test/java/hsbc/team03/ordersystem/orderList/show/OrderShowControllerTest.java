package hsbc.team03.ordersystem.orderList.show;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Project:ordersystem
 * Package:hsbc.team03.ordersystem.orderList.show
 * Author:Alan Ruan
 * Date:2018-08-06 11:33
 * Description://TODO
 */
public class OrderShowControllerTest {


    @MockBean
    private OrderService orderService;

    @Autowired
    private MockMvc mvc;

    private static final String ORDER_JSON_TEST = "{\"status\":1,\"msg\":\"已经是登录状态\",\"data\":{\"Order\":[" +
            "{\"ConsumerName\":\"小明\",\"ProductName\":\"龙卡业务\",\"ProductNum\":1,\"Address\":\"华南师范大学\",\"OrderId\":\"D11\"}," +
            "{\"ConsumerName\":\"小鑫\",\"ProductName\":\"黑金尊贵VIP业务\",\"ProductNum\":2,\"Address\":\"South China Normal University\",\"OrderId\":\"S22\"}]}}";

    @Test
    public void showAllOrder() throws Exception{

        OrderInfo orderInfo1 = new OrderInfo();
        OrderInfo orderInfo2 = new OrderInfo();

        orderInfo1.setOrderId("D11");
        orderInfo1.setConsumerName("小明");
        orderInfo1.setProductName("龙卡业务");
        orderInfo1.setProductNum(1);
        orderInfo1.setAddress("华南师范大学");
        orderInfo1.setOrderTime(new Date());

        orderInfo2.setOrderId("S22");
        orderInfo2.setConsumerName("小鑫");
        orderInfo2.setProductName("黑金尊贵VIP业务");
        orderInfo2.setProductNum(2);
        orderInfo2.setAddress("South China Normal University");
        orderInfo2.setOrderTime(new Date());

        List<OrderInfo> orderInfoList = new ArrayList<>();

        orderInfoList.add(orderInfo1);
        orderInfoList.add(orderInfo2);

        System.out.println(orderInfoList.toString());

        given(this.orderService.findAllOrder()).willReturn(orderInfoList);

        this.mvc.perform(get("/orderlist/show").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())//.andExpect(jsonPath("$.length()").value(3))
                .andExpect(content().string(ORDER_JSON_TEST));

    }
}