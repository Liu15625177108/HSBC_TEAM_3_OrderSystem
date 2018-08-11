package hsbc.team03.ordersystem.displayproduct.common;

import hsbc.team03.ordersystem.displayproduct.Log;
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
                if (product.getProductCode().equals(products.get(i).getProductCode()) && product.getName().equals(products.get(i).getName())) {
                    tag = false;
                    return tag;
                }
                if (!(product.getName().equals(products.get(i).getName())) && product.getProductCode().equals(products.get(i).getProductCode())) {
                    tag = true;
                    return tag;
                }
            }
        }
        return tag;
    }

    /**
     *
     * @param log
     */
    public void setLog(Log log) {
        DataUtils dataUtils = new DataUtils();
        log.setTime(dataUtils.getCurrentTime());
        log.setName("admin");
        log.setId(UUIDUtils.getUUID());
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
        if (!(compareProduct.getName().equals(product.getName()))) {
            msg = "Changed the original product name =" + compareProduct.getName() + " to " + product.getName();
        }
        if (compareProduct.getPrice() != product.getPrice()) {
            msg = "Changed the original product price =" + compareProduct.getPrice();
        }
        if (compareProduct.getPrice() != product.getPrice() && !(compareProduct.getName().equals(product.getName()))) {
            msg = "Changed the original product price and name=" + compareProduct.getPrice() + " " + compareProduct.getName() + "to" + product.getName() + " " + product.getPrice() + " where origin'produceCode is" + compareProduct.getProductCode();
        }
        if (compareProduct.getPrice() != product.getPrice() && !(compareProduct.getProductCode().equals(product.getProductCode()))) {
            msg = "Changed the original product price and produceCode=" + compareProduct.getPrice() + " " + compareProduct.getProductCode() + "to" + product.getProductCode() + " " + product.getPrice();
        }
        if (!(compareProduct.getName().equals(product.getName())) && !(compareProduct.getProductCode().equals(product.getProductCode()))) {
            msg = "Changed the original product name and productCode =" + compareProduct.getName() + " " + compareProduct.getProductCode() + "to " + product.getName() + " " + product.getProductCode();
        }
        if (!(compareProduct.getName().equals(product.getName())) && !(compareProduct.getProductCode().equals(product.getProductCode())) && compareProduct.getPrice() != product.getPrice()) {
            msg = "modify product's name、code and price of product' code =" + compareProduct.getName() + "、" + compareProduct.getProductCode() + "、" + compareProduct.getPrice() + " of origin information is " + product.getName() + "、" + product.getProductCode() + "、" + product.getPrice();
        }
        return msg;
    }


}
