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


import hsbc.team03.ordersystem.toorder.result.ResultViewService;
import hsbc.team03.ordersystem.toorder.result.ResultViewServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@Controller
@RequestMapping(value = "/order")
public class OrdersController {
    @Autowired
    private OrdersService orderService;
    @Autowired
    private UserService userService;
    //    @Autowired
//    private ResultViewService resultViewService;
    private ResultViewService resultViewService = new ResultViewServiceImpl();

    /**
     * @return java.lang.Object
     * @Author Chen
     * @Description //TODO  To place an order
     * @Date 5:52 2018/8/3
     * @Param []
     **/
    @PostMapping(value = "/toorder")
    public @ResponseBody
    Object toOrder(@RequestBody ProductInfo productInfo, @RequestParam("payPassword") String payPassword, HttpServletRequest request) {
        String userId = (String) request.getAttribute("userId");
        System.out.println(userId);
        UserInfo userInfo = userService.getUserInfoByUserId("11");
        if(userInfo!=null){
            System.out.println(userInfo.getUserName()+"++");
            System.out.println(productInfo.getProductName());
        }
        //To compare userMoney and orderPrice
        if (userService.toValidateMoney(userInfo,productInfo)) {
            //to check userPayPassword
            if (userService.toValidatePayPassword(userInfo, payPassword)) {
                if (orderService.insertOrder(productInfo, userInfo)) {
                    return resultViewService.ResultSuccess(23);
                }
                return resultViewService.ResultErrorView(14);
            }
            return resultViewService.ResultErrorView(26);
        }
        return resultViewService.ResultErrorView(27);
    }

    /**
     * @Author Chen
     * @Description //TODO test method
     * @Date 15:29 2018/8/14
     * @Param []
     * @return java.lang.Object
     **/
    @GetMapping(value = "/t1")
    public @ResponseBody
    Object test1() {
        TestInfo testInfo = new TestInfo();
        testInfo.setTestId(11);
        testInfo.setCode(1);
        return null;
    }
    
    /**
     * @Author Chen
     * @Description //TODO to cancel order
     * @Date 15:28 2018/8/4
     * @Param [orderId]
     * @return java.lang.Object
     **/
    @PutMapping(value = "/tocancelorder")
    public @ResponseBody
    Object toCancelOrder(@RequestParam("orderId") String orderId) {
        if (orderId != null && !orderId.equals("")) {
            if (orderService.determineTime(orderId)) {
                orderService.updateOrderStatus(orderId);
                return resultViewService.ResultSuccess(22);
            }
            return resultViewService.ResultErrorView(28);
        }
        return resultViewService.ResultErrorView(29);
    }
}