package hsbc_team_3.ordersystem.bankmanager;

import org.springframework.stereotype.Repository;

/**
 * @ClassName BankManagerServiceDaoImpl
 * @Author:Jerry.Liu;
 * @Description://TODO
 * @Package hsbc_team_3.ordersystem.bankmanager
 * @Date 2018/8/3 12:04
 */

@Repository
public class BankManagerServiceDaoImpl implements  BankManagerServiceDao {
    @Override
    public boolean login(String workernum, String password) {
        return false;
    }

    @Override
    public Object findByWorkernum(String worknum) {
        return null;
    }
}
