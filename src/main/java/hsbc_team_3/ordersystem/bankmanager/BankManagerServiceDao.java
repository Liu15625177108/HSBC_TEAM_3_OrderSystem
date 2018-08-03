package hsbc_team_3.ordersystem.bankmanager;

/**
 * @ClassName BankManagerServiceDao
 * @Author:Jerry.Liu;
 * @Description://TODO
 * @Package hsbc_team_3.ordersystem.bankmanager
 * @Date 2018/8/3 12:03
 */
public interface BankManagerServiceDao {

    boolean login (String workernum,String password);

    Object findByWorkernum(String worknum);
}
