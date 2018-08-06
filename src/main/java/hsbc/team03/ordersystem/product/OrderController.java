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
package hsbc.team03.ordersystem.product;

import hsbc.team03.ordersystem.product.result.ResultView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @description〈the controller of order〉
 * @author Chen
 * @create 2018/8/2
 * @since 1.0.0
 */
@Slf4j
@Controller
@RequestMapping(value = "/order" , produces = "application/json; charset=utf-8")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    
    /**
     * @Author Chen
     * @Description //TODO  To place an order
     * @Date 5:52 2018/8/3
     * @Param []
     * @return java.lang.Object
     **/
    @PostMapping(value = "/toorder")
    public @ResponseBody
    Object toOrder(OrderInfo orderInfo,HttpServletRequest request){
        String userId= (String) request.getSession().getAttribute("userId");
        if(userId!=null&&!userId.equals("")) {
            //To compare userMoney and orderPrice
            if (userService.getMoney() > orderService.getOrderPrice()) {
                //to check userPayPassword
                if (userService.toValidatePayPassword()) {
                    Object resultView = orderService.toOrder();
                    String reuslt = resultView.toString();
                    log.info(reuslt);
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
        String result = "Sorry,you haven't login,please login";
        log.info(result);
        ResultView resultView = new ResultView<String>(401, "error", result);
        return resultView;
    }
}