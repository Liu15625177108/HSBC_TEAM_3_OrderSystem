package hsbc_team_3.ordersystem.bankmanager;

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

    @RequestMapping(path ="/manager/login",method = RequestMethod.GET)
    /**
    *@Author Jerry.Liu
    *@Description: the method of  test the manager's information and login into the system.
    *@Parameter [workerNumber, workerPassword]
    *@Date:10:59 2018/8/3
    *@Package: hsbc_team_3.ordersystem.bankmanager
    */
    public  ReturnValue managerLogin(String workerNumber,String workerPassword){
        ReturnValue returnValue=new ReturnValue();
        returnValue.setCode("200");
        returnValue.setMsg("successful");
        returnValue.setBankManager(new BankManager("123321","Jerry","dev"));
        return  returnValue;
    }


}
