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
 * @Date:2018/8/3 11:23
 * @Describe：
 * @Return:
 * @Param:
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    List<Product> findByStatus(int i);

    Page<Product> findAll(Specification<Product> specification, Pageable pageable);

    /**
     * @param pageable
     * @return
     */
    @Override
    Page<Product> findAll(Pageable pageable);
}
