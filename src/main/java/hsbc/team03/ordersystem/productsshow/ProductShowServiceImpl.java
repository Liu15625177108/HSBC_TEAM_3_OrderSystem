package hsbc.team03.ordersystem.productsshow;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project:ordersystem
 * Package:hsbc_team_3.ordersystem.products
 * Author:Alan Ruan
 * Date:2018-08-03 10:41
 * Description://
 */
@Service
public class ProductShowServiceImpl implements ProductShowService {

    @Override
    public List<ProductInfoView> listAll() {
        return null;
    }

    @Override
    public ProductInfoView showProductDetailsById(String productId){
        return this.getProductById(productId);
    }

    @Override
    public ProductInfoView getProductById(String productId){
        for(ProductInfoView x: listAll()){
            if (productId == x.getProductId()){
                return x;
            }
        }
        return null;
    }
}
