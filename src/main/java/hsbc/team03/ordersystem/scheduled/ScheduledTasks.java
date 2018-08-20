package hsbc.team03.ordersystem.scheduled;

import hsbc.team03.ordersystem.displayproduct.Product;
import hsbc.team03.ordersystem.displayproduct.ProductRepository;
import hsbc.team03.ordersystem.displayproduct.common.DataUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
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
     * @Scheduled(fixedRate = 5000)
     */
   @Scheduled(cron="0 0 0 * * ?")//每天0点开始
    public void reportCurrent() {
        logger.info("现在时间：{}", dateFormat.format(new Date()));
        /*get the product which its status is 1 ,2*/
        List<Product> productList = productRepository.getProduct(1, 2);
        /**get current Time*/
        Long currentTime = System.currentTimeMillis();
        /*add 30 minues so that use to judge currenttime wethere is deadline of dueline*/
        currentTime = currentTime + 30 * 60 * 1000;
        Date date = new Date(currentTime);
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateFormat.format(date));
        String formateCurrentTime = dateFormat.format(date);
        try {
            Date getCurrentTime = dateFormat.parse(formateCurrentTime);
            /**if currenttime is deadline,set the product's status to 2,if currenttime is dueline,set the product's status to 3*/
            DataUtils dataUtils = new DataUtils();
            for (Product product : productList) {
                /*chance the product's deadline to data type*/
                Date productDeadline = dataUtils.formatTime(product.getProductDeadline());
                if (getCurrentTime.getTime() >= productDeadline.getTime()) {
                    product.setStatus(2);
                }
                /**if the currentTime is dueline,set the status to 3*/
                Date productDuedate = dataUtils.formatTime(product.getProductDuedate());
                if (getCurrentTime.getTime() >= productDuedate.getTime()) {
                    product.setStatus(3);
                }
                productRepository.saveAndFlush(product);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
