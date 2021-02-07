package com.yyh.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Description: com.yyh.util
 * @version: 1.0
 */
public class MD5Util {
    public static String md5(String info) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(info.getBytes());
            byte[] md5 = md.digest();
            char[] ch = "0123456789abcdef".toCharArray();
            StringBuilder buf = new StringBuilder();
            for (byte b : md5) {
                buf.append(ch[b >>> 4 & 0xf]);
                buf.append(ch[b & 0xf]);
            }
            return buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
