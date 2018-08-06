package hsbc.team03.ordersystem.orderList.show;

import hsbc.team03.ordersystem.result.ResultView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project:ordersystem
 * Package:hsbc.team03.ordersystem.orderList.show
 * Author:Alan Ruan
 * Date:2018-08-06 09:25
 * Description://TODO
 */
@RestController
@RequestMapping("/orderlist")
public class OrderShowController {

    private OrderService orderService;

    @GetMapping("/show")
    public ResultView showAllOrder(){

        ResultView resultView = new ResultView();
        OrderInfo orderInfo = new OrderInfo();

//        orderInfo.setConsumerName("小明");
//        orderInfo.setProductName("龙卡通");
//        orderInfo.setProductNum(1);
//
        OrderView orderView = new OrderView();
        orderView.setOrderInfoList(this.orderService.findAllOrder());


        resultView.setStatus(1);
        resultView.setMsg("已经是登录状态");
        resultView.setData(orderView);

        System.out.println(resultView.toString());
        return resultView;
    }

}
