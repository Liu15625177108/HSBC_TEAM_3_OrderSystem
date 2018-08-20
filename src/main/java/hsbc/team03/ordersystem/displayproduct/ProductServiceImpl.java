package hsbc.team03.ordersystem.displayproduct;

import hsbc.team03.ordersystem.displayproduct.common.PageableTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

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

    private final PageableTool pageableTool;
    private final ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(PageableTool pageableTool, ProductRepository productRepository) {
        this.pageableTool = pageableTool;
        this.productRepository = productRepository;
    }
    @Override
    public List<Product> getAllProduct() {
        List<Product> list = productRepository.findAll();
        return list;
    }

    @Override
    public Page<Product> getProductListByPage(int page, String productType, int count, Sort sort) {
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
