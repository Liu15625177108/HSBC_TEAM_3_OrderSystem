<<<<<<< HEAD:src/main/java/hsbc/team03/ordersystem/displayproduct/ManagerRepository.java
=======
/*
>>>>>>> 0565a83164174a1aeb20e590e1facb0c30a1c1ca:src/main/java/hsbc/team03/ordersystem/displayproduct/ManagerRepository.java
package hsbc.team03.ordersystem.displayproduct;
import hsbc.team03.ordersystem.displayproduct.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

*/
/**
 * @Author:Evan
 * @Date:2018/8/3 15:08
 * @Describe：
 * @Return:
 * @Param:
 *//*

@Repository
public interface ManagerRepository extends JpaRepository<Product, String> {
    */
/**
     * @param productCode
     * @return findProduct by productCode from database
     *//*

    Product findByProductCode(String productCode);

    */
/**
     *
     * @param id
     * @return
     *//*

    Product findByid(String id);
    */
/**
     * @param
     * @return list
     * @descripe:根据条件，获取产品的产品名和产品代码
     *//*

    List<Product> findByStatus(int n);


}
*/
