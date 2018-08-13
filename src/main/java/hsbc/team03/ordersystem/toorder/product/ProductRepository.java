/**
 * Copyright (C), 2018-2018, CLPS
 * FileName: ProductRepository
 * Author:   ca
 * Date:     2018/8/13 10:22
 * Description: the repository of product
 * History:
 * <author>          <time>          <version>          <desc>
 * Chen          2018/8/13 10:22     1.0              the repository of product
 */
package hsbc.team03.ordersystem.toorder.product;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description<br>
 * 〈the repository of product〉
 *
 * @author Chen
 * @create 2018/8/13
 * @since 1.0.0
 */
public interface ProductRepository extends JpaRepository<ProductInfo,String>{
    
}
 
