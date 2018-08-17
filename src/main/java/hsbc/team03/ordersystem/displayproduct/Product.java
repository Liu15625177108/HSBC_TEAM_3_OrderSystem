package hsbc.team03.ordersystem.displayproduct;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author:Evan
 * @Date:2018/8/2
 * @Describe：产品的详细信息
 */
@Entity
//@EntityListeners()
public class Product {
    /**
     * id--UUID
     */
    @Id
    private String id;
    /**
     * 产品代码：如：004322
     */
    private String productCode;
    /**
     * product' productName
     */
    private String productName;
    /**
     * product'productPrice
     */
    private double productPrice;
    /**
     * product's type
     */
    private String productType;
    /**
     * product' description
     */
    private String description;
    /**
     * product'icon
     */
    private String icon;
    /**
     * 产品发售起始日
     */
    private String productSelldata;
    /**
     * 发售截止日 Sales productDeadline
     */
    private String productDeadline;

    /**
     * 产品到期日
     */
    private String productDuedate;
    /**
     * 产品状态：0表示下架（表示删除），1代表正常(正在出售：此时不能下架该产品)
     */
    private int status=1;

    public Product(String id, String productCode, String productName, double productPrice, String productType, String description, String icon, String productSelldata, String productDeadline, String productDuedate, int status) {
        this.id = id;
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productType = productType;
        this.description = description;
        this.icon = icon;
        this.productSelldata = productSelldata;
        this.productDeadline = productDeadline;
        this.productDuedate = productDuedate;
        this.status = status;
    }

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getProductSelldata() {
        return productSelldata;
    }

    public void setProductSelldata(String productSelldata) {
        this.productSelldata = productSelldata;
    }

    public String getProductDeadline() {
        return productDeadline;
    }

    public void setProductDeadline(String productDeadline) {
        this.productDeadline = productDeadline;
    }

    public String getProductDuedate() {
        return productDuedate;
    }

    public void setProductDuedate(String productDuedate) {
        this.productDuedate = productDuedate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", type='" + productType + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                ", productSelldata='" + productSelldata + '\'' +
                ", productDeadline='" + productDeadline + '\'' +
                ", productDuedate='" + productDuedate + '\'' +
                ", status=" + status +
                '}';
    }
}
