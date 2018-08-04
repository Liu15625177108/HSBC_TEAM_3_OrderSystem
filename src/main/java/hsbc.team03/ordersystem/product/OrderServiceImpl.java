/**
 * Copyright (C), 2018-2018, CLPS
 * FileName: OrderServiceImpl
 * Author:   ca
 * Date:     2018/8/2 17:36
 * Description: the impl of orderservice
 * History:
 * <author>          <time>          <version>          <desc>
 * Chen          2018/8/2 17:36     1.0              the impl of orderservice
 */
package hsbc.team03.ordersystem.product;

import hsbc.team03.ordersystem.commonsutils.CommonsUtils;
import hsbc.team03.ordersystem.result.ResultView;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @description〈the impl of orderservice〉
 * @author Chen
 * @create 2018/8/2
 * @since 1.0.0
 */
@Service
public class OrderServiceImpl implements OrderService{
    /**
     * @Author Chen
     * @Description //TODO TO place the order
     * @Date 5:53 2018/8/3
     * @Param [OrderInfo orderInfo]
     * @return java.lang.Object
     **/
    @Override
    public Object toOrder() {
     /*   orderInfo.setOrderId(CommonsUtils.getUUID());
        orderInfo.setProductName("信用卡");
        orderInfo.setProductNumber(2);
        orderInfo.setUserAddress("岗顶");
        orderInfo.setUserName("Chen");
        orderInfo.setUserPhone("1111111111");
        orderInfo.setProductPrice(300);*/
     
//        ResultView resultView=new ResultView<OrderInfo>(200,"成功",orderInfo);
        return null;
    }
    /**
     * @Author Chen
     * @Description //TODO To get orderprice
     * @Date 5:54 2018/8/3
     * @Param [OrderInfo orderInfo]
     * @return double
     **/
    @Override
    public double getOrderPrice() {
     /*   orderInfo.setProductNumber(2);
        orderInfo.setProductPrice(300);*/
     
//        double orderPice=orderInfo.getProductNumber()*orderInfo.getProductPrice();
        return 0;
    }

 
}