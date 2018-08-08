package hsbc.team03.ordersystem.loginregister;


/**
 * @Package: hsbc_team_3.ordersystem.loginregister
 * @Program: ordersystem
 * @Description: result view for returning
 * @Author: Jeff.Li
 * @Created: 2018年08月03日 11:39:15
 **/

public class ResultView<T> {

    /**
     * code
     */
    private Integer code;

    /**
     * message
     */
    private String msg;

    /**
     * content of data
     */
    private T data;

    public ResultView() {
    }

    public ResultView(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
