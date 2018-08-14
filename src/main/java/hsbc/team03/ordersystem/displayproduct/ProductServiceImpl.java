package hsbc.team03.ordersystem.displayproduct;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//import hsbc.team03.ordersystem.displayproduct.ProductRepository;

/**
 * @Author:Evan
 * @Date:2018/8/2 14:49
 * @Describe：
 * @Return:
 * @Param:
 */
@Service
public class ProductServiceImpl implements ProductService {
    //    private ProductRepository productRepository;
//    @Autowired
//    public ProductServiceImpl(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }
    @Override
    public List<Product> getAllProduct() {
//        List<Product> list = productRepository.findAll();
        List<Product> list=new ArrayList<>();
        return list;
    }

//    @Override
//    public Page<Product> findAll(Pageable pageable) {
//        return productRepository.findAll(pageable);
//    }
}
