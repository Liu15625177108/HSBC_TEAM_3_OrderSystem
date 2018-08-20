package hsbc.team03.ordersystem.displayproduct;

import hsbc.team03.ordersystem.displayproduct.common.PageableTool;
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
        PageableTool pageableTool=new PageableTool();
        Specification<Product> specification=pageableTool.specifucation(productType);
        Pageable pageable = PageRequest.of(page, count, sort);
        return productRepository.findAll(specification, pageable);

//        Page<Product> products= productRepository.findAll();

    }

    @Override
    public List<Product> findByProductCodeOrProductName(String productCode, String productName) {
        return productRepository.findByProductCodeOrProductName(productCode,productName);
    }
}
