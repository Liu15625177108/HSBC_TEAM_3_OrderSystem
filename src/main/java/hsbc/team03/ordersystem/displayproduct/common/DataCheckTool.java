package hsbc.team03.ordersystem.displayproduct.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

/**
 * @Author:Evan
 * @Date:2018/8/10 11:12
 * @Describe：
 * @Return:
 * @Param:
 */
public class DataCheckTool {
    @Value("${fileMax}")
    byte fileSize;
    DataUtils dataUtils = new DataUtils();

    /**
     * @return false or true
     * @method checkProductCode
     * @descripe it check the productCode Whether the effectiveness,it must 0-9
     * @author @Evan
     * @version
     * @date 2018/8/10 11:22
     */
    public boolean checkProductCode(String productCode) {
        String str;
        boolean tag = true;
        int n;
        for (int i = 0; i < productCode.length(); i++) {
            str = productCode.substring(i);
            n = Integer.parseInt(str);
            if (n != 0 || n != 1 || n != 2 || n != 3 || n != 4 || n != 5 || n != 6 || n != 7 || n != 8 || n != 9) {
                tag = false;
            }
        }
        return tag;
    }

    /**
     * @return
     * @method checkName
     * @descripe it check the product'Name Whether the effectiveness
     * @author @Evan
     * @version
     * @date 2018/8/10 11:24
     */
    public boolean checkName(String productName) {

        return false;
    }


    /**
     * @return
     * @method checkIcon
     * @author @Evan
     * @version
     * @descripe it check the product'Icon Whether the effectiveness of ".jpg .png" and son on
     * @date 2018/8/10 11:25
     */
    public Boolean checkIcon(MultipartFile file) throws IOException {
        // file.getBytes(); 文件大小
        String suffix1 = "jpeg";
        String suffix2 = "gif";
        String suffix3 = "png";
        if (file.isEmpty()) {
            return false;
        }
        String fileName = file.getOriginalFilename();
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        if (!(suffix1.equals(suffixName)) && !(suffix2.equals(suffixName)) && !(suffix3.equals(suffixName))) {
            return false;
        }
        if (fileSize < file.getSize()) {
            return false;
        }
        return true;
    }

    /**
     * @return
     * @method checkSellData()
     * @author @Evan
     * @version
     * @descripe it check the product'SellData Whether the effectiveness ,product'selldate must greater than or equals current time
     * @date 2018/8/10 11:28
     */
    public boolean checkSellData(String sellDate) {

        Date sellData1 = dataUtils.formatTime(sellDate);
        Date systemTime = dataUtils.getSystemTime();
        if (sellData1.getTime() - systemTime.getTime() < 0) {
            return false;
        }
        return true;
    }

    /**
     * @return
     * @method
     * @author @Evan
     * @version
     * @descript check the deadline whether effectiveness :The deadline of products must be greater than the product sale date
     * @date 2018/8/10 11:30
     */
    public boolean checkDeadline( String selldate,String deadling, String dueDate) {
        Date deadling1 = dataUtils.formatTime(deadling);
        Date selldate1 = dataUtils.formatTime(selldate);
        Date dueDate1 = dataUtils.formatTime(dueDate);
        /*if the selldate is smaller than deadline,it count not do it */
        if (deadling1.getTime() - selldate1.getTime() <= 0 || deadling1.getTime() - dueDate1.getTime() >= 0) {
            return false;
        }
        return true;
    }

    /**
     * @return
     * @method No such property: code for class: Script1
     * @author @Evan
     * @version
     * @descript check the deadline whether effectiveness :The DueDate of products must be greater than the product sale date and deadline date
     * @date 2018/8/10 11:33
     */
    public boolean checkDueDate() {

        return false;
    }
}
