package com.wist_bean.util;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wist_bean
 * Date: 2018-02-15
 * Time: 10:57
 * Mail: wist_bean@126.com
 */
public class HexConversion {

    /**
     * 二进制转十六进制
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuffer hexStr = new StringBuffer();
        int num;
        for (int i = 0; i < bytes.length; i++) {
            num = bytes[i];
            if(num < 0) {
                num += 256;
            }
            if(num < 16){
                hexStr.append("0");
            }
            hexStr.append(Integer.toHexString(num));
        }
        return hexStr.toString().toUpperCase();
    }
}
