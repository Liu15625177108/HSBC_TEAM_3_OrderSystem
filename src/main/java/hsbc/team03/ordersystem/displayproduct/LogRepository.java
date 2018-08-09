package hsbc.team03.ordersystem.displayproduct;
import hsbc.team03.ordersystem.displayproduct.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.LinkedList;

/**
 * @Author:Evan
 * @Date:2018/8/6 13:56
 * @Describe：
 * @Return:
 * @Param:
 */
public interface LogRepository  extends JpaRepository<Log, String> {
}
