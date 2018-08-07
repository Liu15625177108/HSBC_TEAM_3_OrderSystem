package hsbc.team03.ordersystem.displayproduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
