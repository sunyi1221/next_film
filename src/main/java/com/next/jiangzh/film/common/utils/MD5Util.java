package com.next.jiangzh.film.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 类名称：MD5加密类
 *
 * 创建人： Sunyi
 * 创建时间：2020/9/23 17:56
 *
 * @author Sunyi
 * @date 2020/9/23 17:56
 * @updateRemark 修改备注：MD5加密类
 */
public final class MD5Util {

    /**
     * 构造器私有化，不可实例化
     */
    private MD5Util(){}

    public static String encrypt(String source) {
        return encodeMd5(source.getBytes());
    }

    private static String encodeMd5(byte[] source) {
        try {
            return encodeHex(MessageDigest.getInstance("MD5").digest(source));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    private static String encodeHex(byte[] bytes) {
        StringBuffer buffer = new StringBuffer(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            if (((int) bytes[i] & 0xff) < 0x10)
                buffer.append("0");
            buffer.append(Long.toString((int) bytes[i] & 0xff, 16));
        }
        return buffer.toString();
    }

}
