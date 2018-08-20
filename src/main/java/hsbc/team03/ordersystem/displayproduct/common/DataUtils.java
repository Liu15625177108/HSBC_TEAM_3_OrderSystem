package hsbc.team03.ordersystem.displayproduct.common;

import hsbc.team03.ordersystem.displayproduct.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:Evan
 * @Date:2018/8/4 10:23
 * @Describe：
 * @Return:
 * @Param:
 */
public class DataUtils {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * Format time
     */
    public Date formatTime(String time) {
        Date date = null;
        try {
            date = sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public boolean compareCurrentTimeAndDueDate(Product product) {
        boolean tag = true;
        /*当前时间*/
        String currentTime = sdf.format(new Date());
        Date time1 = formatTime(currentTime);
        /*产品的出售到期时间*/
        Date time2 = formatTime(product.getProductDuedate());
        /*如果当前时间比产品出售的截止时间小，那么该产品不能删除，则返回false*/
        if (time1.getTime()-time2.getTime()<=0) {
            tag = false;
        }
        return tag;
    }

    /**
     * @return String Time
     * @method
     * @author @Evan
     * @version
     * @date 2018/8/6 14:07
     */
    public String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
        return sdf.format(new Date());
    }

    public Date getSystemTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return new Date();
    }
}
