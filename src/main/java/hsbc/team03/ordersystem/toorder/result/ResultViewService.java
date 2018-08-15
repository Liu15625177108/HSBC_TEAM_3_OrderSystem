/**
 * Copyright (C), 2018-2018, CLPS
 * FileName: ResultViewService
 * Author:   ca
 * Date:     2018/8/13 10:44
 * Description: the interface of resultview
 * History:
 * <author>          <time>          <version>          <desc>
 * Chen          2018/8/13 10:44     1.0              the interface of resultview
 */
package hsbc.team03.ordersystem.toorder.result;

/**
 * @description<br>
 * 〈the interface of resultview〉
 * @author Chen
 * @create 2018/8/13
 * @since 1.0.0
 */

public interface ResultViewService {
    ResultView ResultErrorView(int i);
    ResultView ResultSuccess(int i);
}
 
