package hsbc.team03.ordersystem.productsshow;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Project:ordersystem
 * Package:hsbc_team_3.ordersystem.products
 * Author:Alan Ruan
 * Date:2018-08-02 11:56
 * Description://product information
 */
@Data
public class ProductInfoView {

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private double productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;

}
