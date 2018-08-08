package hsbc.team03.ordersystem.displayproduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author:Evan
 * @Date:2018/8/3 11:23
 * @Describe：
 * @Return:
 * @Param:
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    Page<Product> findAll(Pageable pageable);
}
