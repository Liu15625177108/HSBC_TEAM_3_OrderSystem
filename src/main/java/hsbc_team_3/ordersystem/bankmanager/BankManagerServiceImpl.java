package hsbc_team_3.ordersystem.bankmanager;

import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName BankManagerServiceImpl
 * @Author:Jerry.Liu;
 * @Description://TODO
 * @Package hsbc_team_3.ordersystem.bankmanager
 * @Date 2018/8/3 11:55
 */

@Service
public class BankManagerServiceImpl implements BankManagerService {

    @Autowired
    private  BankManagerServiceDao bankManagerServiceDao;

    @Override
    public boolean login(String workernum, String password) {
        return bankManagerServiceDao.login(workernum,password);
    }

    @Override
    public Object findByWorkernum(String worknum) {
        return  bankManagerServiceDao.findByWorkernum(worknum);
    }
}
