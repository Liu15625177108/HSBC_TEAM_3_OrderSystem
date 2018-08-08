/**
 * Copyright (C), 2018-2018, CLPS
 * FileName: OrdersServiceImpl
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

/**
 * @description〈the impl of orderservice〉
 * @author Chen
 * @create 2018/8/2
 * @since 1.0.0
 */
@Service
public class OrdersServiceImpl implements OrdersService {
    /**
     * @Author Chen
     * @Description //TODO TO place the order
     * @Date 5:53 2018/8/3
     * @Param [ProductInfo productInfo,UserInfo userInfo]
     * @return java.lang.Object
     **/
    @Override
    public Object toOrder(ProductInfo productInfo, UserInfo userInfo) {
        OrderInfo orderInfo=new OrderInfo(CommonsUtils.getUUID(),productInfo.getProductName(),
                productInfo.getProdcutNumber(),userInfo.getUserName(),userInfo.getUserPhone(),
                userInfo.getUserAddress(),productInfo.getProdcutPrice());
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

 
}