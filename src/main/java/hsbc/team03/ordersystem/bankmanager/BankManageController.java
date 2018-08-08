package hsbc.team03.ordersystem.bankmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BankManageController
 * @Author:Jerry.Liu;
 * @Description: the contoller of manager,has a method to login into the system of super administrator.
 * @Package hsbc_team_3.ordersystem.bankmanager
 * @Date 2018/8/3 10:41
 */
@RestController
public class BankManageController {

    @Autowired
    private  BankManagerService bankManagerService;


    @RequestMapping(path ="/manager/login",method = RequestMethod.GET)
    /**
    *@Author Jerry.Liu
    *@Description: the method of  test the manager's information and login into the system.
    *@Parameter [workerNumber, workerPassword]
    *@Date:10:59 2018/8/3
    *@Package: hsbc_team_3.ordersystem.bankmanager
    */
    public  ReturnValue managerLogin(@RequestParam(value = "workernumber",required = true) String workerNumber,
                                     @RequestParam(value = "password",required = true)String workerPassword) {
        if (bankManagerService.login(workerNumber, workerPassword) == true) {
            ReturnValue<BankManager> returnValue = new ReturnValue<BankManager>();
            BankManager bankManager = (BankManager) bankManagerService.findByWorkernum(workerNumber);
            returnValue.setCode("200");
            returnValue.setMsg("success");
            returnValue.setBankManager(bankManager);
            return returnValue;
        } else {
            ReturnValue<BankManager> returnValue = new ReturnValue<BankManager>();
            returnValue.setCode("500");
            returnValue.setMsg("failure");
            returnValue.setBankManager(null);
            return returnValue;
        }
    }
}
