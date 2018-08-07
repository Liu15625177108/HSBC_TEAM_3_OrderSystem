package hsbc.team03.ordersystem.loginregister;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Package: hsbc_team_3.ordersystem.loginregister
 * @Program: ordersystem
 * @Description: login api entrance
 * @Author: Jeff.Li
 * @Created: 2018年08月03日 10:29:15
 **/
@RestController
@RequestMapping("/user/login")
public class LoginController {

    @Autowired
    private LoginServices loginServices;

    /**
     * @param username, password, request
     * @return ResultView
     * @Description user login api
     */
    @GetMapping("/dologin")
    public ResultView login(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
        ResultView resultView = new ResultView();
        UserInfo userInfo = loginServices.findUserByUsername(username);
        if (userInfo == null) {
            resultView.setCode(500);
            resultView.setMsg("user not exist");
        } else if (userInfo.getPassword().equals(password)) {
            resultView.setCode(200);
            resultView.setMsg("OK");
            request.getSession().setAttribute("user", userInfo);
        } else {
            resultView.setCode(500);
            resultView.setMsg("wrong password");
        }
        return resultView;
    }

}
