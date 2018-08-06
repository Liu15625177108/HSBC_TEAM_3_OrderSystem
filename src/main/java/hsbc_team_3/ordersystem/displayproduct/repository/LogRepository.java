package hsbc_team_3.ordersystem.displayproduct.repository;
import hsbc.team03.ordersystem.displayproduct.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author:Evan
 * @Date:2018/8/6 13:56
 * @Describe：
 * @Return:
 * @Param:
 */
public interface LogRepository  extends JpaRepository<Log, String> {
}
