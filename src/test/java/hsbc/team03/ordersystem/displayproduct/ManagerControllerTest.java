package hsbc.team03.ordersystem.displayproduct;

import com.alibaba.fastjson.JSONObject;
import hsbc.team03.ordersystem.displayproduct.common.UUIDUtils;
<<<<<<< HEAD
import org.junit.Before;
=======
>>>>>>> 0565a83164174a1aeb20e590e1facb0c30a1c1ca
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.boot.test.context.SpringBootTest;
=======
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
>>>>>>> 0565a83164174a1aeb20e590e1facb0c30a1c1ca
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
<<<<<<< HEAD
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
=======
>>>>>>> 0565a83164174a1aeb20e590e1facb0c30a1c1ca
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
<<<<<<< HEAD
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
=======
//@SpringBootTest
@WebMvcTest(ManagerController.class)
public class ManagerControllerTest {

    private WebApplicationContext context;
    @Autowired
    private MockMvc mvc;

    @MockBean
    private ManagerService managerService;

    /*  @Before
      public void setUp() {
          mvc = MockMvcBuilders.webAppContextSetup(context).build();
      }
  */
    @Test
    public void getProductTest() throws Exception {
        List<Product> list = new ArrayList<>();
        Mockito.when(managerService.productList()).thenReturn(list);
        this.mvc.perform(get("/manager/productlist")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON))
>>>>>>> 0565a83164174a1aeb20e590e1facb0c30a1c1ca
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void managerAddProduct() throws Exception {
<<<<<<< HEAD
        Mockito.when(managerServiceImpl.addProduct(Mockito.any(Product.class))).thenReturn(true);
=======
        Mockito.when(managerService.addProduct(Mockito.any(Product.class))).thenReturn(true);
>>>>>>> 0565a83164174a1aeb20e590e1facb0c30a1c1ca

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
<<<<<<< HEAD
        Mockito.when(managerServiceImpl.deleteProductByProductCode(Mockito.any(Product.class))).thenReturn(1);
=======
        Mockito.when(managerService.deleteProductByProductCode(Mockito.any(Product.class))).thenReturn(1);
>>>>>>> 0565a83164174a1aeb20e590e1facb0c30a1c1ca
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
<<<<<<< HEAD
        Mockito.when(managerServiceImpl.modifyProduct(Mockito.any(Product.class))).thenReturn(true);
        Product product = new Product("ewfsdgsrhdfgxvadfgsfnxzdz", "010101", "gaile", 20.8, "稳", "这是一个", "http://8080", "2018-7-1", "2018-8-10", "2018-7-3", 1);
        String jsondata = JSONObject.toJSONString(product);
        this.mvc.perform(post("/manager/modify/products")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content(jsondata)
        .accept(MediaType.APPLICATION_JSON))
=======
        Mockito.when(managerService.modifyProduct(Mockito.any(Product.class))).thenReturn(true);
        Product product = new Product("ewfsdgsrhdfgxvadfgsfnxzdz", "010101", "gaile", 20.8, "稳", "这是一个", "http://8080", "2018-7-1", "2018-8-10", "2018-7-3", 1);
        String jsondata = JSONObject.toJSONString(product);
        this.mvc.perform(post("/manager/modify/products")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsondata)
                .accept(MediaType.APPLICATION_JSON))
>>>>>>> 0565a83164174a1aeb20e590e1facb0c30a1c1ca
                .andExpect(status().isOk());

    }
}
