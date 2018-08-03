package hsbc_team_3.ordersystem.bankmanager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @ClassName BankManageControllerTest
 * @Author:Jerry.Liu;
 * @Description://TODO
 * @Package hsbc_team_3.ordersystem.bankmanager
 * @Date 2018/8/3 10:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BankManageControllerTest {



    @Autowired
    //reject web factory
    private WebApplicationContext wac;
    //simulate mvc environment;
    private MockMvc mockMvc;
    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
    @Test
    /**
    *@Author Jerry.Liu
    *@Description: test for "/manager/login"
    *@Parameter []
    *@Date:10:58 2018/8/3
    *@Package: hsbc_team_3.ordersystem.bankmanager
    */
    public void managerLogin() throws Exception{
        String result =
                mockMvc.perform(get("/manager/login").accept(MediaType.APPLICATION_JSON))       // return json's message
                .andExpect(status().isOk())                             // ensure the http.code is ok;
                .andExpect(jsonPath("$.length()").value(3))     //  ensure the length of json is 3
                .andReturn().getResponse().getContentAsString();                            // return reponse's value
        Logger logger= LoggerFactory.getLogger(BankManageControllerTest.class);
        logger.info(result);                                                                //  output




    }
}