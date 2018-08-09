package hsbc.team03.ordersystem.displayproduct;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author:Evan
 * @Date:2018/8/9 10:27
 * @Describe：
 * @Return:
 * @Param:
 */
public interface LogService {
    String getSystemLog(int n, HttpServletResponse response);
}
