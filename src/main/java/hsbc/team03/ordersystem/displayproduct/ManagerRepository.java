package hsbc.team03.ordersystem.displayproduct;
import hsbc.team03.ordersystem.displayproduct.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Evan
 * @Date:2018/8/3 15:08
 * @Describe：
 * @Return:
 * @Param:
 */
@Repository
public interface ManagerRepository extends JpaRepository<Product, String> {
    /**
     * @param productCode
     * @return findProduct by productCode from database
     */
    Product findByProductCode(String productCode);

    Page<Product> findAll(Specification<Product> specification, Pageable pageable);



    /**
     *
     * @param id
     * @return
     */
    Product findByid(String id);
    /**
     * @param
     * @return list
     * @descripe:根据条件，获取产品的产品名和产品代码
     */
    List<Product> findByStatus(int n);

    /**
     *  manager find product by product's name or productCode
     * @param productCode
     * @param productName
     * @return
     */
    List<Product> findByProductCodeOrProductName(String productCode,String productName);

}
