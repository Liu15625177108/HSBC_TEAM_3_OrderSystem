/**
 * Copyright (C), 2018-2018, CLPS
 * FileName: TestInfo
 * Author:   ca
 * Date:     2018/8/13 22:10
 * Description: test pojo
 * History:
 * <author>          <time>          <version>          <desc>
 * Chen          2018/8/13 22:10     1.0              test pojo
 */
package hsbc.team03.ordersystem.toorder.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @description〈test pojo〉
 * @author Chen
 * @create 2018/8/13
 * @since 1.0.0
 */

@Entity
public class TestInfo implements Serializable {
    @Id
    @JsonProperty(value = "testid")
    private int testId;
    @JsonProperty(value = "testid")
    private int code;

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}