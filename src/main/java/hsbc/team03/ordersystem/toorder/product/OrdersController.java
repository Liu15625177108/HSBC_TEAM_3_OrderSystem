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
    public
    Object toOrder(@RequestBody ProductInfo productInfo, @RequestParam("payPassword") String payPassword, HttpServletRequest request) {
        String userId = (String) request.getSession().getAttribute("userId");
        System.out.println(userId);
        UserInfo userInfo = userService.getUserInfoByUserId(userId);
        //To compare userMoney and orderPrice
        if (userInfo.getUserMoney() > orderService.getOrderPrice(productInfo.getProductNumber(), productInfo.getProductPrice())) {
            //to check userPayPassword
            if (userService.toValidatePayPassword(userInfo, payPassword)) {
                if (orderService.toOrder(productInfo, userInfo)) {
                    return resultViewService.ResultSuccess(23);
                }
                return resultViewService.ResultSuccess(23);
            }
            return resultViewService.ResultSuccess(26);
        }
        return resultViewService.ResultSuccess(27);
    }

    @GetMapping(value = "/t1")
    public @ResponseBody
    TestInfo test1() {
//        UserInfo userInfo = new UserInfo("11", "chen", 1.2, "12", "123", "汕头");
//        ResultView resultview = new ResultView<UserInfo>(200, "success", userInfo);
//        userService.addTest(userInfo);
//        String result="add +++++++";
//        ResultView resultview = new ResultView<String>(200, "success", result);
        /*OrdersInfo ordersInfo=new OrdersInfo("111","难",
                1,"chen","111",
                "地球", 11.1,1,new Date());*/
        TestInfo testInfo = new TestInfo();
        testInfo.setTestId(11);
        testInfo.setCode(1);
        return testInfo;
    }
    @PutMapping(value = "/tocancelorder")
    public @ResponseBody
    Object toCancelOrder(@RequestParam("orderId") String orderId) {
        if (orderId != null && !orderId.equals("")) {
            if (orderService.toCancelOrder(orderId)) {
                orderService.updateOrderStatus(orderId);
                return resultViewService.ResultSuccess(22);
            };
            return resultViewService.ResultSuccess(28);
        }
        return resultViewService.ResultSuccess(29);
    }
}