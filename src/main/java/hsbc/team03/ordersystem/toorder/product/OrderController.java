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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    private OrdersService ordersService;
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
    public @ResponseBody
    Object toOrder(@RequestBody ProductInfo productInfo, String payPassword, HttpServletRequest request) {
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
        if (userInfo != null && !userInfo.equals("")) {

            //To compare userMoney and orderPrice
            if (userInfo.getUserMoney() > ordersService.getOrderPrice(productInfo.getProdcutNumber(), productInfo.getProdcutPrice())) {

                //to check userPayPassword
                if (userService.toValidatePayPassword(userInfo, payPassword)) {

                        Object resultView = ordersService.toOrder(productInfo, userInfo);
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

            String result = "Sorry,you haven't login,please login";
            log.info(result);
            ResultView resultView = new ResultView<String>(401, "error", result);
            return resultView;

        }

    }
