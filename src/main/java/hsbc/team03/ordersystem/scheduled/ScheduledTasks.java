package hsbc.team03.ordersystem.scheduled;

import hsbc.team03.ordersystem.displayproduct.Product;
import hsbc.team03.ordersystem.displayproduct.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author:Evan
 * @Date:2018/8/19 21:13
 * @Describe：
 * @Return:
 * @Param:
 */
@Component
public class ScheduledTasks {
    private static Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat();
    @Autowired
    private ProductRepository productRepository;

    /**
     * @Scheduled(cron="0 0 0 * * ?")//每天0点开始
     */
    @Scheduled(fixedRate = 5000)
    public void reportCurrent() {
        logger.info("现在时间：{}", dateFormat.format(new Date()));
        /*get the product which its status is 1 ,2*/
        List<Product> productList = productRepository.getProduct(1,2);
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(productList.get(i).getProductCode());
        }
        /**get current Time*/
        Long currentTime = System.currentTimeMillis();
        currentTime = currentTime + 30 * 60 * 1000;
        Date date = new Date(currentTime);
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateFormat.format(date));
    }
}
