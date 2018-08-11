package hsbc.team03.ordersystem.displayproduct;

import com.alibaba.fastjson.JSONObject;
import hsbc.team03.ordersystem.displayproduct.common.UUIDUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Author:Evan
 * @Date:2018/8/7 11:01
 * @Describe：
 * @Return:
 * @Param:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerControllerTest {
    @Autowired
    private WebApplicationContext context;
    private MockMvc mvc;

    @MockBean
    private ManagerServiceImpl managerServiceImpl;
    @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void getProductTest() throws Exception {
        List<Product> list=new ArrayList<>();
        Mockito.when(managerServiceImpl.productList()).thenReturn(list);
        this.mvc.perform(get("/user/get/products")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void managerAddProduct() throws Exception {
//        Mockito.when(managerServiceImpl.addProduct(Mockito.any(Product.class))).thenReturn(true);

        Product product = new Product();
        product.setId(UUIDUtils.getUUID());
        product.setProductCode("231701");
        product.setName("中海");
        product.setPrice(20.8);
        product.setType("稳健型");
        product.setDescription("这是1");
        product.setStatus(1);
        product.setDeadline("2018-8-10");
        String requestJson = JSONObject.toJSONString(product);
        mvc.perform(
                post("/manager/add/products")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(requestJson)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());


    }


    @Test
    public void managerDeleteProduct() throws Exception {
        Mockito.when(managerServiceImpl.deleteProductByProductCode(Mockito.any(Product.class))).thenReturn(1);
        Product product = new Product("xdghhmbhnllllgcgxdf", "200871", "中海基金", 20.8, "稳健型", "这是一个值得1", "http://8080", "2018-7-1", "2018-8-10", "2018-7-3", 1);
        String jsondata = JSONObject.toJSONString(product);
        mvc.perform(
                delete("/manager/delete/products")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(jsondata)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void managerModifyProduct() throws Exception {
//        Mockito.when(managerServiceImpl.modifyProduct(Mockito.any(Product.class))).thenReturn(true);
//        Product product = new Product("ewfsdgsrhdfgxvadfgsfnxzdz", "010101", "gaile", 20.8, "稳", "这是一个", "http://8080", "2018-7-1", "2018-8-10", "2018-7-3", 1);
//        String jsondata = JSONObject.toJSONString(product);
//        this.mvc.perform(post("/manager/modify/products")
//        .contentType(MediaType.APPLICATION_JSON_UTF8)
//        .content(jsondata)
//        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());

    }
}
