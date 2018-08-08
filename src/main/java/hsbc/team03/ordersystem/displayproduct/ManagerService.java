package hsbc.team03.ordersystem.displayproduct;


import hsbc.team03.ordersystem.displayproduct.Product;

import java.util.List;

/**
 * @Author:Evan
 * @Date:2018/8/2 14:46
 * @Describe：
 * @Return: products
 * @Param:
 */

public interface ManagerService {
    /**this is manager to get all the products*/
    List<Product> productList();

    /**
     * @descripe:add product
     * @param product
     * @return boolean
     *
     */
    boolean addProduct(Product product);

    /**
     * @param product
     * @return int 0:fail,1:success
     */
    int deleteProductByProductCode(Product product);
    /**
     * @Descript:it is modify the product's information
     * @param product
     * @return
     */
   boolean modifyProduct(Product product);
}
