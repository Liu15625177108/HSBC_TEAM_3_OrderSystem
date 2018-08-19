package hsbc.team03.ordersystem.displayproduct;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * @Author:Evan
 * @Date:2018/8/2 14:47
 * @Describe：
 * @Return:
 * @Param:
 */
public interface ProductService {
    /**
     * @return :list
     * @Description: get the all products
     * @Author: @Evan
     * @CreateDate: 2018/8/5 22:16
     * @UpdateDate: 2018/8/5 22:16
     * @Version: 1.0
     */
    List<Product> getAllProduct();

    Page<Product> getProductListByPage(int page, String productType, int count, Sort sort);

    /**
     *
     * @param productCode
     * @param productName
     * @return
     */
    List<Product> findByProductCodeOrProductName(String productCode, String productName);

}
