/**
 * Copyright (C), 2018-2018, CLPS
 * FileName: UserRepository
 * Author:   ca
 * Date:     2018/8/13 10:23
 * Description: the repository of user
 * History:
 * <author>          <time>          <version>          <desc>
 * Chen          2018/8/13 10:23     1.0              the repository of user
 */
package hsbc.team03.ordersystem.toorder.product;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description<br>
 * 〈the repository of user〉
 *
 * @author Chen
 * @create 2018/8/13
 * @since 1.0.0
 */
public interface UserRepository extends JpaRepository<UserInfo,String> {
    
}
 
