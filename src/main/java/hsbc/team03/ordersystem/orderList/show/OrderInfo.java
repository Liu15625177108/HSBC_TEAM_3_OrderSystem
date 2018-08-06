package hsbc.team03.ordersystem.orderList.show;

/**
 * Project:ordersystem
 * Package:hsbc_team_3.ordersystem.orderList
 * Author:Alan Ruan
 * Date:2018-08-03 17:30
 * Description:// 订单中的详细信息
 */
public class OrderInfo {

    //顾客姓名
    private String consumerName;

    //商品名称
    private String productName;

    //商品数量
    private int productNum;

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }
}
