package hsbc.team03.ordersystem.result;

import java.io.Serializable;

/**
 * Project:ordersystem
 * Package:hsbc_team_3.ordersystem.result
 * Author:Alan Ruan
 * Date:2018-08-02 13:13
 * Description://
 */
public class ResultView<T> implements Serializable {

    //login status code
    private Integer status;

    //login tips
    private String msg;

    //detail
    private T data;


    /**
     * @Method set /  get
     * @Description //get / set method
     * @Author Alan Ruan
     * @Date 2018/08/07 09:41:26
     */

    public void setData(T data) {
        this.data = data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public T getData() {
        return data;

    }

    public String getMsg() {
        return msg;
    }

    public Integer getStatus() {
        return status;

    }

    @Override
    public String toString(){
        return "status: " + this.status + "; msg: " + this.msg + "; data: " + this.data.toString();
    }
}
