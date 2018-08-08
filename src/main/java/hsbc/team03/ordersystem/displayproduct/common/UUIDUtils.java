package hsbc.team03.ordersystem.displayproduct.common;

import java.util.UUID;

/**get a UUID
 * The author:Evan
 */

public class UUIDUtils {
    public static String getUUID(){
        String uuidRaw = UUID.randomUUID().toString();
        return uuidRaw.replaceAll("-", "");
    }
}
