package hsbc_team_3.ordersystem.controller;


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
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.swing.text.AbstractDocument;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import static org.junit.Assert.*;

/**
 * @ClassName MyControllerTest
 * @Author:Jerry.Liu;
 * @Description://MyController's test class
 * @Author:Administrator
 * @Package com.example.test.controller
 * @Date 2018/7/31 16:21
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class MyControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;        //用于模拟mvc测试。

    @Before
    public  void setup(){
        mockMvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test

    /**
     *@Author Jerry.Liu
     *@Description:    test  for "localhost:8080/show"
     *@Parameter []
     *@Date:16:24 2018/7/31
     *@Package: com.example.test.controller
     */
    public void show() throws Exception{
        String result= mockMvc.perform(get("/show").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3))
                .andReturn().getResponse().getContentAsString();
        Logger logger=LoggerFactory.getLogger(MyControllerTest.class);
        logger.info(result);

    }
}