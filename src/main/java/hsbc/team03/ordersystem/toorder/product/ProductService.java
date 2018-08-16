/**
 * Copyright (C), 2018-2018, CLPS
 * FileName: ProductService
 * Author:   ca
 * Date:     2018/8/15 14:43
 * Description: the interface of product
 * History:
 * <author>          <time>          <version>          <desc>
 * Chen          2018/8/15 14:43     1.0              the interface of product
 */
package hsbc.team03.ordersystem.toorder.product;

/**
 * @description<br>
 * 〈the interface of product〉
 *
 * @author Chen
 * @create 2018/8/15
 * @since 1.0.0
 */
public interface ProductService {
    ProductInfo getProductInfoByProductId(String productId);
}
 
