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

}
