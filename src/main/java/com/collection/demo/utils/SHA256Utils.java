package com.collection.demo.utils;


import org.apache.tomcat.util.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author wangwn
 */
public class SHA256Utils {

    /***
     * 字符串 SHA256 加密
     *
     * @param strText
     * @return
     */
    public static byte[] SHA256(final String strText) {
        // 是否是有效字符串
        if (strText != null && strText.length() > 0) {
            MessageDigest messageDigest;
            try {
                messageDigest = MessageDigest.getInstance("SHA-256");
                messageDigest.update(strText.getBytes("UTF-8"));
                // 得到 byte 類型结果
                return messageDigest.digest();

            } catch (NoSuchAlgorithmException e) {
                return null;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * 将byte转为16进制
     *
     * @param bytes
     * @return
     */
    public static String bytetoHex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            String temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                //16进制数值长度为2,长度为1时补0
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

    /**
     * @param codeStr 原始字符串
     * @return
     */
    public static String encryptSign(String codeStr) {
        byte[] hashBytes = SHA256Utils.SHA256(codeStr);
        return Base64.encodeBase64String(hashBytes);
    }
}
