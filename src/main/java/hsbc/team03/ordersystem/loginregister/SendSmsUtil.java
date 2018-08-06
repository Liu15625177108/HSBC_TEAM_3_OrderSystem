package hsbc.team03.ordersystem.loginregister;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Package: hsbc_team_3.ordersystem.loginregister
 * @Program: ordersystem
 * @Description: util of sending sms to phone
 * @Author: Jeff.Li
 * @Created: 2018年08月03日 09:28:02
 **/
public class SendSmsUtil {

    /**
     * ACCOUNT_SID:开发者主账号ID(注册后自动生成)
     */
    private static final String ACCOUNT_SID = "77cdd719ee6643158d9460dd1d5a844e";

    /**
     * AUTH_TOKEN:开发者账号认证密匙(注册后自动生成)
     */
    private static final String AUTH_TOKEN = "13efd7bdb04f4a5aa8a969bc05bd9cf3";

    /**
     * BASE_URL:请求地址
     */
    private static final String BASE_URL = "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";

    /**
     * RESP_DATA_TYPE:数据返回格式为JSON格式
     */
    private static final String RESP_DATA_TYPE = "json";

    /**
     * smsContent:短信内容(短信签名+短信内容，注意要和配置的模板一致，否则报错)
     */
    public static String smsContent = "【三组科技】尊敬的用户，您的验证码为";

    /**
     * @Title：sendMsgTo
     * @Description：send verify message
     * @param：
     * @return：String
     */
    public static String sendMsgTo(String to, String code) {

        /*获取时间戳*/
        String timestamp = getTimestamp();

        /*获取签名 */
        String sig = sigMD5(ACCOUNT_SID + AUTH_TOKEN + timestamp);

        /*
         * 要提交的post数据
         */
        String httpPost = "accountSid=" + ACCOUNT_SID
                + "&smsContent=" + smsContent + code
                + "&to=" + to
                + "&timestamp=" + timestamp
                + "&sig=" + sig
                + "&respDataType=" + RESP_DATA_TYPE;

        OutputStreamWriter osw = null;
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer();
        try {

            /*获取连接*/
            URL url = new URL(BASE_URL);

            /*打开连接*/
            URLConnection conn = url.openConnection();

            /*设置连接参数*/
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(20000);

            /* 提交数据*/
            osw = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            osw.write(httpPost);
            osw.flush();

            /*读取返回数据*/
            br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * @Title:getTimestamp
     * @Description: get the timestamp to send to remote sms server
     * @param:
     * @return:String
     */
    private static String getTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = sdf.format(new Date());
        return date;
    }

    /**
     * @Title:sig_MD5
     * @Description:对"ACCOUNT_SID + AUTH_TOKEN + timestamp"进行MD5加密，
     * 这里使用的是apache.commons.codec.digest.DigestUtils;
     * 需要引入jar包：commons-codec-1.11.jar
     * @param:
     * @return:String
     */
    public static String sigMD5(String str) {
        return DigestUtils.md5Hex(str);
    }

    /**
     * @Title:createRandNum
     * @Description: generate a 6-bit random decimal number string
     * @param:
     * @return:String
     */
    public static String createRandNum() {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <= 5; i++) {
            String s = random.nextInt(10) + "";
            sb.append(s);
        }
        return sb.toString();
    }

}