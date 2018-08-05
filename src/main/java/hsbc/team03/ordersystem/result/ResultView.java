package hsbc.team03.ordersystem.result;

/**
 * Project:ordersystem
 * Package:hsbc_team_3.ordersystem.result
 * Author:Alan Ruan
 * Date:2018-08-02 13:13
 * Description://TODO
 */
public class ResultView<T> {

    //登录状态码
    private Integer status;

    //登录提示信息
    private String msg;

    //具体内容
    private T data;

    public void setData(T data) {
        this.data = data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
