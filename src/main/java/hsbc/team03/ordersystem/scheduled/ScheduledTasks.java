package hsbc.team03.ordersystem.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:Evan
 * @Date:2018/8/19 21:13
 * @Describe：
 * @Return:
 * @Param:
 */
@Component
public class ScheduledTasks {
    private static Logger logger=LoggerFactory.getLogger(ScheduledTasks.class);
    private static SimpleDateFormat dateFormat=new SimpleDateFormat();
   @Scheduled(fixedRate = 1000)
    public void reportCurrent(){
        logger.info("现在时间：{}",dateFormat.format(new Date()));

    }
}
