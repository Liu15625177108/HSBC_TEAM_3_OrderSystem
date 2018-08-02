package hsbc_team_3.ordersystem.products;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Project:ordersystem
 * Package:hsbc_team_3.ordersystem.products
 * Author:Alan Ruan
 * Date:2018-08-02 15:30
 * Description://TODO
 */
public class ProductControllerTest {

    private MockMvc mvc;

    @Test
    public void getList() throws Exception{
        this.mvc.perform(get("/list").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).toString();
    }
}