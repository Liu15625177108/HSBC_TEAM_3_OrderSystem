package hsbc_team_3.ordersystem.common;

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
