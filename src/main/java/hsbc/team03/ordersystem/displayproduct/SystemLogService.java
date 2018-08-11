package hsbc.team03.ordersystem.displayproduct;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author:Evan
 * @Date:2018/8/9 10:27
 * @Describe：
 * @Return:
 * @Param:
 */
public interface SystemLogService {
    String getSystemLog(int n, HttpServletResponse response);

    /**
     * 分页查询（search by page）
     * @param request
     * @return
     */
    Page<SystemLog> getSystemLogListPage(PageRequest request);
}
