package hsbc.team03.ordersystem.displayproduct.common;

import hsbc.team03.ordersystem.displayproduct.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Evan
 * @Date:2018/8/20 9:50
 * @Describe：
 * @Return:
 * @Param:
 */
@Component
public class PageableTool {
    public Specification<Product> specifucation(String productType){
        Specification<Product> specification = new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                  /* return criteriaBuilder.in(root.get("status")).value(1);*/

                List<Predicate> predicates = new ArrayList<Predicate>();
                Path<Long> status = root.get("status");
                Predicate predicate = criteriaBuilder.equal(status, 1);
                predicates.add(predicate);
                Path<Long> path = root.get("productType");
                Predicate predicate1 = criteriaBuilder.equal(path, productType);
                predicates.add(predicate1);
                return criteriaBuilder.and(predicates
                        .toArray(new Predicate[] {}));
            }
        };
        return specification;
    }
}
