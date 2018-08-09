package hsbc.team03.ordersystem.displayproduct;

import hsbc.team03.ordersystem.displayproduct.Product;
import hsbc.team03.ordersystem.displayproduct.ProductRepository;
import hsbc.team03.ordersystem.displayproduct.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Override
    public List<Product> getAllProduct() {
        Product product1 = new Product("ewfsdgsrhdfgxvadfgsfnxzdz1", "200701", "中非让", 20.8, "稳", "这是一个", "http://8080", "2018-7-1", "2018-8-10", "2018-7-3", 1);
        Product product2 = new Product("ewfsdgsrhdfgxvadfgsfnxzdz2", "200701", "中非让", 20.8, "稳", "这是一个", "http://8080", "2018-7-1", "2018-8-10", "2018-7-3", 1);
        Product product3 = new Product("ewfsdgsrhdfgxvadfgsfnxzdz3", "200701", "中非让", 20.8, "稳", "这是一个", "http://8080", "2018-7-1", "2018-8-10", "2018-7-3", 1);
        List<Product> list=new ArrayList<>();
        list.add(product1);
        list.add(product2);
        list.add(product3);
        return list;
    }


    /*   private ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public List<Product> getAllProduct() {
        List<Product> list = productRepository.findAll();
        return list;
    }

//    @Override
//    public Page<Product> findAll(Pageable pageable) {
//        return productRepository.findAll(pageable);
//    }*/
}
