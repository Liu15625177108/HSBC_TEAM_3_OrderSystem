/**
 * Copyright (C), 2018-2018, CLPS
 * FileName: ProductServiceImpl
 * Author:   ca
 * Date:     2018/8/15 14:45
 * Description: the impl of product
 * History:
 * <author>          <time>          <version>          <desc>
 * Chen          2018/8/15 14:45     1.0              the impl of product
 */
package hsbc.team03.ordersystem.toorder.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description〈the impl of productservice〉
 * @author Chen
 * @create 2018/8/15
 * @since 1.0.0
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private  ProductRepository productRepository;
    @Override
    public ProductInfo getProductInfoByProductId(String productId) {
        return productRepository.findByProductId(productId);
    }
}