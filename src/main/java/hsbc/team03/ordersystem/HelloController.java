package hsbc.team03.ordersystem;

/**
 * Project:ordersystem
 * Package:hsbc.team03.ordersystem
 * Author:Alan Ruan
 * Date:2018-08-14 15:04
 * Description://TODO
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller

public class HelloController {
    @RequestMapping("/index")
    public String index(){
        return "Welcome";
    }
}
