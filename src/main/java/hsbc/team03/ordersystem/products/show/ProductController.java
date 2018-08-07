package hsbc.team03.ordersystem.products.show;

import hsbc.team03.ordersystem.result.ResultView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Project:ordersystem
 * Package:hsbc_team_3.ordersystem.products
 * Author:Alan Ruan
 * Date:2018-08-02 13:19
 * Description://TODO
 */
@RestController
@RequestMapping("/user/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ResultView getList(){

        ResultView<ProductView> resultView = new ResultView<ProductView>();
        ProductView productView = new ProductView();
//        ProductInfoView productInfoView = new ProductInfoView();

//        ArrayList<ProductInfoView> list = new ArrayList<>();
//
//        productInfoView.setProductId("1");
//        productInfoView.setProductName("朝朝盈");
//        productInfoView.setProductPrice(4.44);
//        productInfoView.setProductDescription("稳赚不亏");
//        productInfoView.setProductIcon("www.icon.com");
//
//        list.add(productInfoView);

        productView.setProductInfoViewList(productService.listAll());

        resultView.setStatus(1);
        resultView.setMsg("已经登录");
        resultView.setData(productView);

        return resultView;
    }

}
