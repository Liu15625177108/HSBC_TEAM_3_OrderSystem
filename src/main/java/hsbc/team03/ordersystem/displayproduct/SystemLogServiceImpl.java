package hsbc.team03.ordersystem.displayproduct;

import hsbc.team03.ordersystem.displayproduct.common.SystemLogTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * @Author:Evan
 * @Date:2018/8/9 10:31
 * @Describe：
 * @Return:
 * @Param:
 */
@Service
public class SystemLogServiceImpl implements SystemLogService {
    public static final String FAIL = "无满足要求的数据";
    public static final String SUCCESS = "系统日志导出成功";
    final SystemLogRepository systemLogRepository;

    @Autowired
    public SystemLogServiceImpl(SystemLogRepository systemLogRepository) {
        this.systemLogRepository = systemLogRepository;
    }

    @Override
    public String getSystemLog(int n, HttpServletResponse response) {
        /*1：得到所有的系统日志*/
        List<SystemLog> systemLogList = systemLogRepository.findAll();
        try {
            /*2：对系统日志的筛选：对日期的筛选*/
            SystemLogTool systemLogTool = new SystemLogTool();
            List<SystemLog> systemLogs = systemLogTool.screeningSystemLog(n, systemLogList);
            /*3:if the systemLogs'size > 0,it has recorxd ,then output the record to excel table*/
            if (systemLogs.size() > 0) {
                systemLogTool.exportSystomLogToExcel(systemLogs, response);
                return SUCCESS;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FAIL;
    }

    @Override
    public Page<SystemLog> getSystemLogListPage(PageRequest request) {
        return systemLogRepository.findAll(request);
    }
}
