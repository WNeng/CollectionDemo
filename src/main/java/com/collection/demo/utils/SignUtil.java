package com.collection.demo.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * @author wangwn
 */
public class SignUtil {


    public static String createSign(Map<String, String> params, String appKey, boolean encode)
            throws UnsupportedEncodingException {
        Set<String> keysSet = params.keySet();
        Object[] keys = keysSet.toArray();
        Arrays.sort(keys);
        StringBuffer temp = new StringBuffer();
        for (Object key : keys) {
            temp.append(key);
            Object value = params.get(key);
            String valueString = "";
            if (null != value) {
                valueString = String.valueOf(value);
            }
            if (encode) {
                temp.append(URLEncoder.encode(valueString, "UTF-8"));
            } else {
                temp.append(valueString);
            }
        }
        temp.append(appKey);
        System.out.println("preStrTemp = " + temp.toString());
        return SHA256Utils.encryptSign(temp.toString());
    }



    public static String getTimeStampStr(){

        return String.valueOf(System.currentTimeMillis());
    }


}
