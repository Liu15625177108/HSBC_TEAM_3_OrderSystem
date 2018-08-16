package hsbc.team03.ordersystem.productsshow;

import java.util.List;

/**
 * Project:ordersystem
 * Package:hsbc_team_3.ordersystem.products
 * Author:Alan Ruan
 * Date:2018-08-03 10:39
 * Description://
 */
public interface ProductShowService {

    /**
     * @Method listAll
     * @Description // list all product information
     * @Author Alan Ruan
     * @Date 2018/08/03 10:41:22
     * @Param []
     * @Return java.util.List<ProductInfoView>
     */
    List<ProductInfoView> listAll();

    /**
     * @Method showProductDetailsById
     * @Description //TODO
     * @Author Alan Ruan
     * @Date 2018/08/16 11:15:35
     * @Param [productId]
     * @Return hsbc.team03.ordersystem.productsshow.ProductInfoView
     */
    ProductInfoView showProductDetailsById(String productId);

    /**
     * @Method getProductById
     * @Description //TODO
     * @Author Alan Ruan
     * @Date 2018/08/16 11:16:32
     * @Param [productId]
     * @Return hsbc.team03.ordersystem.productsshow.ProductInfoView
     */
    ProductInfoView getProductById(String productId);
}
