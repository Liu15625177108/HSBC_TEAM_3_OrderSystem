package hsbc.team03.ordersystem.commonsutils;

import java.util.UUID;

public class CommonsUtils {

	//生成uuid方法
	public static String getUUID(){
		return UUID.randomUUID().toString();
	}
	
}