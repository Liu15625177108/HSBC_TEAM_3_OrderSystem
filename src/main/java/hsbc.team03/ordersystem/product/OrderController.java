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

import hsbc.team03.ordersystem.result.ResultView;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    Object toOrder( @RequestBody ProductInfo productInfo,String payPassword,HttpServletRequest request){
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
        System.out.println(userInfo.getUserName());
        System.out.println(productInfo.getProdcutNumber());
        if(userInfo!=null&&!userInfo.equals("")) {
            
            //To compare userMoney and orderPrice
            if (userInfo.getUserMoney()> orderService.getOrderPrice(productInfo.getProdcutNumber(),productInfo.getProdcutPrice())) {
                
                //to check userPayPassword
                if (userService.toValidatePayPassword(userInfo,payPassword)) {
                    
                    Object resultView = orderService.toOrder(productInfo,userInfo);
                    if(resultView==null){
                    System.out.println("+++---");}
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