package hsbc.team03.ordersystem.displayproduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author:Evan
 * @Date:2018/8/9 10:25
 * @Describe：
 * @Return:
 * @Param:
 */
@RestController
public class LogController {

    @Autowired
    LogService logService;

    @RequestMapping(value = "/get/systemlog")
    public void getSystemLogList(int n, HttpServletResponse response) {
        String str = logService.getSystemLog(n, response);
    }
}
