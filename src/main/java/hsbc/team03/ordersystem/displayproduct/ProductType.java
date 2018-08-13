package hsbc.team03.ordersystem.displayproduct;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

/**
 * @Author:Evan
 * @Date:2018/8/12 16:37
 * @Describe：
 * @Return:
 * @Param:
 */
@Entity
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**product's type*/
    private String productType;

    /**产品类型描述 ：Description of product type*/
    private String description;

    /**期限 deadline*/
    private String deadline;

    /**估算利率：To estimate the interest rate*/
    private String rate;

    public ProductType(String productType) {
        this.productType = productType;
    }

    public ProductType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
