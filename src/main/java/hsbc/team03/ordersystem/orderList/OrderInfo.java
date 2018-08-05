package hsbc.team03.ordersystem.orderList;

import hsbc.team03.ordersystem.products.ProductInfo;

import java.util.List;

/**
 * Project:ordersystem
 * Package:hsbc_team_3.ordersystem.orderList
 * Author:Alan Ruan
 * Date:2018-08-03 17:30
 * Description://TODO
 */
public class OrderInfo {

    //订单状态码, 1表示已支付, 0表示未支付
    private Integer status;

    //订单详情信息, 包含了产品的
    private List<ProductInfo> orderInformation;

}
