package hsbc_team_3.ordersystem.products;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Project:ordersystem
 * Package:hsbc_team_3.ordersystem.products
 * Author:Alan Ruan
 * Date:2018-08-02 11:54
 * Description://TODO
 */
public class ProductView {

    @JsonProperty("products")
    private List<ProductInfoView> productInfoViewList;

    public void setProductInfoViewList(List<ProductInfoView> productInfoViewList) {
        this.productInfoViewList = productInfoViewList;
    }
}
