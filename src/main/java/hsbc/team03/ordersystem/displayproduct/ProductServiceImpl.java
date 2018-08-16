package hsbc.team03.ordersystem.displayproduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Pageable;

/**
 * @Author:Evan
 * @Date:2018/8/2 14:49
 * @Describe：
 * @Return:
 * @Param:
 */
@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public List<Product> getAllProduct() {
        List<Product> list = productRepository.findAll();
        return list;
    }

    @Override
    public Page<Product> getProductListByPage(int page, String productType, int count, Sort sort) {
        Specification<Product> specification = new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//                return criteriaBuilder.in(root.get("status")).value(1);

                List<Predicate> predicates = new ArrayList<Predicate>();
                Path<Long> status = root.get("status");
                Predicate predicate = criteriaBuilder.equal(status, 1);
                predicates.add(predicate);
                Path<Long> path = root.get("productType");
//               String productType= String
                Predicate predicate1 = criteriaBuilder.equal(path, productType);
                predicates.add(predicate1);
                return criteriaBuilder.and(predicates
                        .toArray(new Predicate[] {}));
            }
        };

        Pageable pageable = PageRequest.of(page, count, sort);
        return productRepository.findAll(specification, pageable);

//        Page<Product> products= productRepository.findAll();

    }
}
