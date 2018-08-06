package hsbc.team03.ordersystem.loginregister;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author : Jeff.Li
 * @Package : hsbc_team_3.ordersystem.loginregister
 * @Program : ordersystem
 * @description : test the login function
 * @created: 2018年08月03日 14:51:01
 **/
@RunWith(SpringRunner.class)
@WebMvcTest(LoginController.class)
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LoginServicesImpl loginServices;

    /**
     * @param
     * @return void
     * @Description test login api
     */
    @Test
    public void testLogin() throws Exception {

        UserInfo userInfo = new UserInfo();
        userInfo.setPassord("123456");
        userInfo.setUsername("ljf");

        given(loginServices.findUserByUsername("ljf")).willReturn(userInfo);

        this.mockMvc.perform(get("/user/login/dologin?username=ljf&password=123456").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"code\":200,\"msg\":\"OK\",\"data\":null}"));

        this.mockMvc.perform(get("/user/login/dologin?username=ljf&password=1234").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"code\":500,\"msg\":\"wrong password\",\"data\":null}"));

        this.mockMvc.perform(get("/user/login/dologin?username=lf&password=123456").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"code\":500,\"msg\":\"user not exist\",\"data\":null}"));
    }
}
