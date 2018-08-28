package utils;

import java.security.MessageDigest;

/**
 * @author Mengnan Shi
 * @create 2018-08-27-23:15
 */

public class Utils {

    public static String getMd5(String string){
        try {
            java.security.MessageDigest md5 = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md5.digest(string.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }

}
