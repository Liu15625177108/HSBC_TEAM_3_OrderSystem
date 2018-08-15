package hsbc.team03.ordersystem.displayproduct;


import hsbc.team03.ordersystem.displayproduct.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @Author:Evan
 * @Date:2018/8/2 14:46
 * @Describe：
 * @Return:  products
 * @Param:
 */

public interface ManagerService {
    /**this is manager to get all the products*/
    /**
     * @param page
     * @param productType
     * @param count
     * @param sort
     * @return
     */
    Page<Product> getProductListByPage(int page, String productType, int count, Sort sort);

    /**
     * @descripe:add product
     * @param product
     * @return boolean
     *
     */
    boolean addProduct(Product product,MultipartFile file) throws IOException;

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
   boolean modifyProduct(Product product, MultipartFile file) throws IOException;

    List<ProductType> getProductType();
}
