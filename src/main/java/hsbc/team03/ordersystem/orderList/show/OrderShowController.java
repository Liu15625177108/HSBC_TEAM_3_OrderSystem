package hsbc.team03.ordersystem.orderList.show;

import hsbc.team03.ordersystem.result.ResultView;

import java.util.Date;

/**
 * Project:ordersystem
 * Package:hsbc.team03.ordersystem.orderList.show
 * Author:Alan Ruan
 * Date:2018-08-06 09:25
 * Description://TODO
 */
public class OrderShowController {

    private OrderService orderService;

    public ResultView showAllOrder(){

        ResultView resultView = new ResultView();

        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setConsumerName("小明");
        orderInfo.setProductName("龙卡通");
        orderInfo.setProductNum(1);

        OrderView orderView = new OrderView();

        orderView.setOrderTime(new Date());
        orderView.setAddress("华南师范大学");
        orderView.setOrderId("12345");
        orderView.setOrderInfo(orderInfo);

        resultView.setStatus(1);
        resultView.setMsg("已经登录");
        resultView.setData(orderView);

        System.out.println(resultView.toString());
        return resultView;
    }

}
