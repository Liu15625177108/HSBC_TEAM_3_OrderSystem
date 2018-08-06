/**
 * Copyright (C), 2018-2018, CLPS
 * FileName: ResultView
 * Author:   ca
 * Date:     2018/8/2 21:05
 * Description: the class of reuslte to show
 * History:
 * <author>          <time>          <version>          <desc>
 * Chen          2018/8/2 21:05     1.0              the class of reuslte to show
 */
package hsbc.team03.ordersystem.product.result;

import lombok.Data;

/**
 * @description〈the class of reuslte to show〉
 * @author Chen
 * @create 2018/8/2
 * @since 1.0.0
 */
@Data
public class ResultView<T>{
    /** status */
    private Integer status;

    /** message */
    private String msg;

    /** content of data */
    private T data;
   /* *//** content of data *//*
    private String status;*/
    
    public ResultView(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
}