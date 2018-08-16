package hsbc.team03.ordersystem.displayproduct;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
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
     * product' name
     */
    private String name;
    /**
     * product'price
     */
    private double price;
    /**
     * product's type
     */
    private String type;
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
    private String sellData;
    /**
     * 发售截止日 Sales deadline
     */
    private String deadline;

    /**
     * 产品到期日
     */
    private String dueDate;
    /**
     * 产品状态：0表示下架（表示删除），1代表正常(正在出售：此时不能下架该产品)
     */
    private int status=1;

    public Product(String id, String productCode, String name, double price, String type, String description, String icon, String sellData, String deadline, String dueDate, int status) {
        this.id = id;
        this.productCode = productCode;
        this.name = name;
        this.price = price;
        this.type = type;
        this.description = description;
        this.icon = icon;
        this.sellData = sellData;
        this.deadline = deadline;
        this.dueDate = dueDate;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getSellData() {
        return sellData;
    }

    public void setSellData(String sellData) {
        this.sellData = sellData;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
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
                ", name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                ", sellData='" + sellData + '\'' +
                ", deadline='" + deadline + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", status=" + status +
                '}';
    }
}
