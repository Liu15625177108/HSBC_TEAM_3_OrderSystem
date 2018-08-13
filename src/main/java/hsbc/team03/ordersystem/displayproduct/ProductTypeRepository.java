package hsbc.team03.ordersystem.displayproduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author:Evan
 * @Date:2018/8/12 16:56
 * @Describe：
 * @Return:
 * @Param:
 */
public interface ProductTypeRepository extends JpaRepository<ProductType, Integer> {
    /**
     * find all product'type
     * @return
     */
//    @Query(value = "select productType from productType",nativeQuery=true)
//    List<ProductType> findProductType();
}
