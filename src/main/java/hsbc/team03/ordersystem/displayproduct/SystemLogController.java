package hsbc.team03.ordersystem.displayproduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author:Evan
 * @Date:2018/8/9 10:25
 * @Describe：
 * @Return:
 * @Param:
 */
@RestController
public class SystemLogController {

    @Autowired
    SystemLogService systemLogService;
    @RequestMapping(value = "/export/systemlog",method = RequestMethod.POST)
    public void getSystemLogList(int n, HttpServletResponse response) {
        String str = systemLogService.getSystemLog(n, response);
    }

    @GetMapping("/get/system/log/list")
    public Page<SystemLog> getSystemLogList(){
        Sort sort = Sort.by("type");
        PageRequest request = PageRequest.of(0, 2, sort);
        Page<SystemLog> logs = systemLogService.getSystemLogListPage(request);
        return logs;
    }
}
