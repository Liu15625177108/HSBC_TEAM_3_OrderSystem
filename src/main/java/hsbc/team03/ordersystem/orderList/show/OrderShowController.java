package hsbc.team03.ordersystem.orderList.show;

import hsbc.team03.ordersystem.result.ResultView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project:ordersystem
 * Package:hsbc.team03.ordersystem.orderList.show
 * Author:Alan Ruan
 * Date:2018-08-06 09:25
 * Description://
 */
@RestController
@RequestMapping("/orderlist")
public class OrderShowController {

    @Autowired
    private OrderService orderService;

    /**
     * @Method showAllOrder
     * @Description // show all order
     * @Author Alan Ruan
     * @Date 2018/08/07 09:36:27
     * @Param []
     * @Return hsbc.team03.ordersystem.result.ResultView
     */
    @GetMapping("/show")
    public ResultView showAllOrder(){

        ResultView resultView = new ResultView();

        OrderView orderView = new OrderView();
        orderView.setOrderInfoList(orderService.findAllOrder());

        resultView.setStatus(1);
        resultView.setMsg("已经是登录状态");
        resultView.setData(orderView);

        System.out.println(resultView.toString());
        return resultView;
    }

}
