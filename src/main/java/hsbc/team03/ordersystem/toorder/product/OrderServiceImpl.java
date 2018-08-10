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
package hsbc.team03.ordersystem.toorder.product;

import hsbc.team03.ordersystem.toorder.commonsutils.CommonsUtils;
import hsbc.team03.ordersystem.toorder.result.ResultView;
import org.springframework.stereotype.Service;

import java.util.Date;

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
     * @Param [ProductInfo productInfo,UserInfo userInfo]
     * @return java.lang.Object
     **/
    @Override
    public Object toOrder(ProductInfo productInfo,UserInfo userInfo) {
        OrderInfo orderInfo=new OrderInfo(CommonsUtils.getUUID(),productInfo.getProductName(),
                productInfo.getProdcutNumber(),userInfo.getUserName(),userInfo.getUserPhone(),
                userInfo.getUserAddress(),productInfo.getProdcutPrice(),1,new Date());
        ResultView resultView=new ResultView<OrderInfo>(200,"成功",orderInfo);
        return resultView;
    }
    /**
     * @Author Chen
     * @Description //TODO To get orderprice
     * @Date 5:54 2018/8/3
     * @Param [int productNumber,double productPrice]
     * @return double
     **/
    @Override
    public double getOrderPrice(int productNumber,double productPrice) {

        double orderPice=productNumber*productPrice;
        return orderPice;
    }
    
    /**
     * @Author Chen
     * @Description //TODO 
     * @Date 10:21 2018/8/10
     * @Param [orderId]
     * @return boolean
     **/
    @Override
    public boolean toCancelOrder(String orderId) {
        OrderInfo orderInfo=getOrderInfoByOrderId(orderId);
        Date date=new Date();
        Date date1=new Date(date.getTime()- 7* 60 * 60 * 1000);
        System.out.println(date1+"@111111");
        if(date1.before(orderInfo.getStartTime())){
            return true;
        }
        return false;
    }

    @Override
    public OrderInfo getOrderInfoByOrderId(String orderId) {
        return null;
    }


}