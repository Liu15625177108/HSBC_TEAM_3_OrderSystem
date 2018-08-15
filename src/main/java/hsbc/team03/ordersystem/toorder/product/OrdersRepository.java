/**
 * Copyright (C), 2018-2018, CLPS
 * FileName: OrdersRepository
 * Author:   ca
 * Date:     2018/8/13 9:50
 * Description: the re
 * History:
 * <author>          <time>          <version>          <desc>
 * Chen          2018/8/13 9:50     1.0              the re
 */
package hsbc.team03.ordersystem.toorder.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.*;

/**
 * @description<br>
 * 〈the repository of orders〉
 * @author Chen
 * @create 2018/8/13
 * @since 1.0.0
 */
public interface OrdersRepository extends JpaRepository<OrdersInfo,String> {
    OrdersInfo findByorderId(String orderId);
}
 
