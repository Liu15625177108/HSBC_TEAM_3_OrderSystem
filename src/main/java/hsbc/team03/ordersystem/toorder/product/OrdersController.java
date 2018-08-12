/**
 * Copyright (C), 2018-2018, CLPS
 * FileName: OrderController
 * Author:   ca
 * Date:     2018/8/2 17:35
 * Description: the controller of order
 * History:
 * <author>          <time>          <version>          <desc>
 * Chen          2018/8/2 17:35     1.0              the controller of order
 */
package hsbc.team03.ordersystem.toorder.product;

import hsbc.team03.ordersystem.toorder.result.ResultView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Chen
 * @description〈the controller of order〉
 * @create 2018/8/2
 * @since 1.0.0
 * , produces = "application/json; charset=utf-8"
 */
@Slf4j
@RestController
@RequestMapping(value = "/order")
public class OrdersController {
    @Autowired
    private OrdersService orderService;
    @Autowired
    private UserService userService;

    /**
     * @return java.lang.Object
     * @Author Chen
     * @Description //TODO  To place an order
     * @Date 5:52 2018/8/3
     * @Param []
     **/
    @PostMapping(value = "/toorder")
    public
    Object toOrder(@RequestBody ProductInfo productInfo, @RequestParam("payPassword") String payPassword, HttpServletRequest request) {
        String userId = (String) request.getSession().getAttribute("userId");
        UserInfo userInfo = userService.getUserInfoByUserId(userId);
        //To compare userMoney and orderPrice
        if (userInfo.getUserMoney() > orderService.getOrderPrice(productInfo.getProductNumber(), productInfo.getProductPrice())) {

            //to check userPayPassword
            if (userService.toValidatePayPassword(userInfo, payPassword)) {

                Object resultView = orderService.toOrder(productInfo, userInfo);
                String result = resultView.toString();
                log.info(result);
                return resultView;

            }

            String result = "Sorry,your password is wrong,please reenter it";
            log.info(result);
            ResultView resultView = new ResultView<String>(401, "error", result);
            return resultView;

        }

        String result = "Sorry,your money is not enough,please recharge";
        log.info(result);
        ResultView resultView = new ResultView<String>(401, "error", result);
        return resultView;
    }

    @GetMapping(value = "/t1")
    public
    Object test1() {
        UserInfo userInfo = new UserInfo("11", "chen", 1.2, "12", "123", "汕头");
        ResultView resultview= new ResultView<UserInfo>(200, "success", userInfo);
        return resultview;
    }

    @PutMapping(value = "/tocancelorder")
    public
    Object toCancelOrder(@RequestParam("orderId") String orderId) {
        if (orderId != null && !orderId.equals("")) {
            if (orderService.toCancelOrder(orderId)) {
                orderService.updateOrderStatus(orderId);
                String result = "Your order has been cancelled";
                ResultView resultView = new ResultView<String>(200, "success", result);
                return resultView;
            }
            String result = "Your order cancellation failure,because has been more than seven days";
            ResultView resultView = new ResultView<String>(401, "error", result);
            return resultView;
        }
        String result = "Sorry,you must select at least one order";
        ResultView resultView = new ResultView<String>(401, "error", result);
        return resultView;
    }
}