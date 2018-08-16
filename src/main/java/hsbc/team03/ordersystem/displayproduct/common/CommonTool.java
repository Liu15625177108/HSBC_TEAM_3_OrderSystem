package hsbc.team03.ordersystem.displayproduct.common;

import hsbc.team03.ordersystem.displayproduct.SystemLog;
import hsbc.team03.ordersystem.displayproduct.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @Author:Evan
 * @Date:2018/8/10 17:40
 * @Describe：
 * @Return:
 * @Param:
 */
public class CommonTool {
    /**
     * @Description: the method check productCode whether exist,if it exist,return true,else return false
     * @Author: @Evan
     * @CreateDate: 2018/8/5 22:10
     * @UpdateDate: 2018/8/5 22:10
     * @Version: 1.0
     */
    public boolean checkUniqueOfProduct(Product product, List<Product> products) {
        /*先得到所有产品的唯一属性：产品代码：productCode、产品名：name*/
        boolean tag = true;
        if (products != null) {
            for (int i = 0; i < products.size(); i++) {
                if (product.getProductCode().equals(products.get(i).getProductCode()) && product.getProductName().equals(products.get(i).getProductName())) {
                    tag = false;
                    return tag;
                }
                if (!(product.getProductName().equals(products.get(i).getProductName())) && product.getProductCode().equals(products.get(i).getProductCode())) {
                    tag = true;
                    return tag;
                }
            }
        }
        return tag;
    }

    /**
     *
     * @param systemLog
     */
    public void setLog(SystemLog systemLog) {
        DataUtils dataUtils = new DataUtils();
        systemLog.setTime(dataUtils.getCurrentTime());
        systemLog.setName("admin");
        systemLog.setId(UUIDUtils.getUUID());
    }

    /**
     *
     * @param product
     * @param file
     * @return
     * @throws IOException
     */
    public boolean checkData(Product product, MultipartFile file) throws IOException {
        boolean productCodeBoolean;

        /*check the product's code unique*/
        /*check the product'code in a suitable format */
        DataCheckTool dataCheckTool = new DataCheckTool();
        productCodeBoolean = dataCheckTool.checkProductCode(product.getProductCode());
        /*if productCodeBoolean is true then it can go next step */
        if (productCodeBoolean) {
                /**check checkDeadline*/
                boolean deadlineBoolean = dataCheckTool.checkDeadline(product.getSellData(), product.getDeadline(), product.getDueDate());
                if (deadlineBoolean) {
                    return true;
                }
            }
        return false;
    }

    /**
     * @param product
     * @param compareProduct
     * @return
     */
    public String getMessage(Product product, Product compareProduct) {
        String msg = "";
        if (!(compareProduct.getProductCode().equals(product.getProductCode()))) {
            msg = "Changed the original product code =" + compareProduct.getProductCode() + " to " + product.getProductCode();
        }
        if (!(compareProduct.getProductName().equals(product.getProductName()))) {
            msg = "Changed the original product name =" + compareProduct.getProductName() + " to " + product.getProductName();
        }
        if (compareProduct.getProductPrice() != product.getProductPrice()) {
            msg = "Changed the original product price =" + compareProduct.getProductPrice();
        }
        if (compareProduct.getProductPrice() != product.getProductPrice() && !(compareProduct.getProductName().equals(product.getProductName()))) {
            msg = "Changed the original product price and name=" + compareProduct.getProductPrice() + " " + compareProduct.getProductName() + "to" + product.getProductName() + " " + product.getProductPrice() + " where origin'produceCode is" + compareProduct.getProductCode();
        }
        if (compareProduct.getProductPrice() != product.getProductPrice() && !(compareProduct.getProductCode().equals(product.getProductCode()))) {
            msg = "Changed the original product price and produceCode=" + compareProduct.getProductPrice() + " " + compareProduct.getProductCode() + "to" + product.getProductCode() + " " + product.getProductPrice();
        }
        if (!(compareProduct.getProductName().equals(product.getProductName())) && !(compareProduct.getProductCode().equals(product.getProductCode()))) {
            msg = "Changed the original product name and productCode =" + compareProduct.getProductName() + " " + compareProduct.getProductCode() + "to " + product.getProductName() + " " + product.getProductCode();
        }
        if (!(compareProduct.getProductName().equals(product.getProductName())) && !(compareProduct.getProductCode().equals(product.getProductCode())) && compareProduct.getProductPrice() != product.getProductPrice()) {
            msg = "modify product's name、code and price of product' code =" + compareProduct.getProductName() + "、" + compareProduct.getProductCode() + "、" + compareProduct.getProductPrice() + " of origin information is " + product.getProductName() + "、" + product.getProductCode() + "、" + product.getProductPrice();
        }
        return msg;
    }


}
