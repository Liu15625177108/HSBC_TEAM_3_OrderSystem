package hsbc.team03.ordersystem.loginregister.controller;

import hsbc.team03.ordersystem.loginregister.pojo.UserInfo;
import hsbc.team03.ordersystem.loginregister.resultview.ResultView;
import hsbc.team03.ordersystem.loginregister.security.JwtTool;
import hsbc.team03.ordersystem.loginregister.security.JwtUserInfo;
import hsbc.team03.ordersystem.loginregister.services.LoginServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @package : hsbc_team_3.ordersystem.loginregister
 * @program : ordersystem
 * @description : login api entrance
 * @author : Jeff.Li
 * @date : 2018年08月03日 10:29:15
 **/
@RestController
@RequestMapping("/user/login")
public class LoginController {

    private final LoginServices loginServices;

    private final JwtTool jwtTool;

    @Autowired
    public LoginController(LoginServices loginServices, JwtTool jwtTool) {
        this.loginServices = loginServices;
        this.jwtTool = jwtTool;
    }

    /**
     * @param username, password, request
     * @return ResultView
     * @description user login api
     */
    @GetMapping("/dologin")
    public ResultView login(@RequestParam String username, @RequestParam String password, HttpServletResponse response) {
        ResultView resultView = new ResultView();
        UserInfo userInfo = loginServices.findUserByUsername(username);
        if (userInfo == null) {
            resultView.setCode(500);
            resultView.setMsg("user not exist");
        } else if (userInfo.getPassword().equals(password)) {
            resultView.setCode(200);
            resultView.setMsg("OK");
            JwtUserInfo jwtUserInfo = new JwtUserInfo(userInfo.getUserId(), userInfo.getUsername(), userInfo.getPassword());
            response.setHeader("Authorization", "Bearer " + jwtTool.generateToken(jwtUserInfo));
//            request.getSession().setAttribute("userId", userInfo.getUserId());
        } else {
            resultView.setCode(500);
            resultView.setMsg("wrong password");
        }
        return resultView;
    }

}
