package hsbc_team_3.ordersystem.products;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Project:ordersystem
 * Package:hsbc_team_3.ordersystem.products
 * Author:Alan Ruan
 * Date:2018-08-02 11:54
 * Description://TODO
 */
public class ProductView {

    @JsonProperty("products")
    private ArrayList<ProductInfoView> productInfoViewList;

    public void setProductInfoViewList(ArrayList<ProductInfoView> productInfoViewList) {
        this.productInfoViewList = productInfoViewList;
    }
}
