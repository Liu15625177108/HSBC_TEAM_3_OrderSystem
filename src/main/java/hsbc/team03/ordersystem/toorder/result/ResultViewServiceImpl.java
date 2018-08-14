/**
 * Copyright (C), 2018-2018, CLPS
 * FileName: ResultViewServiceImpl
 * Author:   ca
 * Date:     2018/8/13 10:47
 * Description: to impl resultview
 * History:
 * <author>          <time>          <version>          <desc>
 * Chen          2018/8/13 10:47     1.0              to impl resultview
 */
package hsbc.team03.ordersystem.toorder.result;

import hsbc.team03.ordersystem.toorder.enums.ResultEnum;
import org.springframework.stereotype.Service;

/**
 * @description〈to impl resultview〉
 * @author Chen
 * @create 2018/8/13
 * @since 1.0.0
 */
@Service
public class ResultViewServiceImpl implements ResultViewService {

    @Override
    public ResultView ResultErrorView(int i) {
//        ResultView resultView = new ResultView();
//        resultView.setCode(10);
//        resultView.setMsg(ResultEnum.PRODUCT_NOT_EXIST.getMessage());
//        resultView.setData(ResultEnum.PARAM_ERROR.getMessage());
//
//        return resultView;
        if(i==27){
            ResultView resultView=new ResultView<String>(401,"error",ResultEnum.MONEY_NOT_ENOUGH.getMessage());
            return resultView;
        }else if(i==26){
            ResultView resultView=new ResultView<String>(401,"error",ResultEnum.PAY_PASSWORD_FAIL.getMessage());
            return resultView;
        }else if(i==28){
            ResultView resultView=new ResultView<String>(401,"error",ResultEnum.ORDER_CANCEL_FAIL.getMessage());
            return resultView;
        }else if(i==29){
            ResultView resultView=new ResultView<String>(401,"error",ResultEnum.SELECT_NOT_ENOUGH.getMessage());
            return resultView;
            
        }


        return null;
    }

    @Override
    public ResultView ResultSuccess(int i) {
        if(i==22){
            ResultView resultView=new ResultView<String>(200,"success",ResultEnum.ORDER_CANCEL_SUCCESS.getMessage());
            return resultView;
        }else if(i==23){
            ResultView resultView=new ResultView<String>(200,"success",ResultEnum.ORDER_FINISH_SUCCESS.getMessage());
            return resultView;
        }
        return null;
    }
}