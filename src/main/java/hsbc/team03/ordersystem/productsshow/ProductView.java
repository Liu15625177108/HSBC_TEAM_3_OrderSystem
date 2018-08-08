package hsbc.team03.ordersystem.productsshow;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Project:ordersystem
 * Package:hsbc_team_3.ordersystem.products
 * Author:Alan Ruan
 * Date:2018-08-02 11:54
 * Description://
 */
public class ProductView {

    @JsonProperty("products")
    private List<ProductInfoView> productInfoViewList;

    /**
     * @Method get /set
     * @Description //get / set method
     * @Author Alan Ruan
     * @Date 2018/08/07 09:40:25
     */
    public void setProductInfoViewList(List<ProductInfoView> productInfoViewList) {
        this.productInfoViewList = productInfoViewList;
    }

    public List<ProductInfoView> getProductInfoViewList() {
        return productInfoViewList;
    }
}
