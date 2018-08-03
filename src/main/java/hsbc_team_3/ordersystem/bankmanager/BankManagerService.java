package hsbc_team_3.ordersystem.bankmanager;

import org.springframework.stereotype.Service;

/**
 * @ClassName BankManagerService
 * @Author:Jerry.Liu;
 * @Description://TODO
 * @Package hsbc_team_3.ordersystem.bankmanager
 * @Date 2018/8/3 11:40
 */

public interface BankManagerService{

    boolean login (String workernum,String password);

    Object findByWorkernum(String worknum);


}
