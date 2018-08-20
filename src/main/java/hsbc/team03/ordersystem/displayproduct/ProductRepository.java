package hsbc.team03.ordersystem.displayproduct;
import hsbc.team03.ordersystem.displayproduct.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Evan
 * @Date:2018/8/3 11:23
 * @Describe：
 * @Return:
 * @Param:
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    /**
     * @descript: find product of which its status 1 or 2
     * @Method :findAllByStatus
     * @return
     */
    @Query(value = "SELECT * FROM product where status=?1 or status=?2",nativeQuery = true)
     List<Product> getProduct(int n,int m);
//    @Query("select * from Product u where u.sex=?1")

    /**
     * @method findByStatus
     * @descript it find product of its status of 1
     * @param i
     * @return
     */
    List<Product> findByStatus(int i);

    /**
     * @method findAll
     * @param specification
     * @param pageable
     * @descript find by product's type and its status of 1
     * @return
     */
    Page<Product> findAll(Specification<Product> specification, Pageable pageable);

    /**
     * @param pageable
     * @return
     */
    @Override
    Page<Product> findAll(Pageable pageable);

    /**
     *
     * @param productCode
     * @param productName
     * @return
     */
    List<Product> findByProductCodeOrProductName(String productCode, String productName);

}
