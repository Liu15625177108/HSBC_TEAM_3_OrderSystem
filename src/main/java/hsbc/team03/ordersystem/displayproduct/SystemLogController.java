package hsbc.team03.ordersystem.displayproduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
/**
 * @Author:Evan
 * @Date:2018/8/9 10:25
 * @Describe：
 * @Return:
 * @Param:
 */
@Controller
public class SystemLogController {

    @Autowired
    SystemLogService systemLogService;

    @RequestMapping(value = "/export/systemlog", method = { RequestMethod.GET,RequestMethod.POST })
    public String getSystemLogList( int n,HttpServletResponse response) {
        System.out.println(n);
        String str = systemLogService.getSystemLog(n, response);
        return str;
    }

    @GetMapping("/get/system/log/list")
    @ResponseBody
    public Page<SystemLog> getSystemLogList(@RequestParam(name = "pageNumber", defaultValue = "0") int pageNum) {
        Sort sort = Sort.by("time");
        PageRequest request = PageRequest.of(pageNum, 5, sort);
        Page<SystemLog> logs = systemLogService.getSystemLogListPage(request);
        return logs;
    }


}
