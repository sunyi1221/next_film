package com.next.jiangzh.film.common.utils;


import java.util.regex.Pattern;

/**
 * 类名称：公用工具类
 *
 * 创建人： Sunyi
 * 创建时间：2020/9/24 17:25
 *
 * @author Sunyi
 * @date 2020/9/24 17:25
 * @updateRemark 修改备注：公用工具类
 */
public final class ToolUtils {

    /**
     * 构造器私有化，不可实例化
     */
    private ToolUtils(){}

    /**
     * 方法描述：判断字符串是否为空
     *
     * @param src 字符串
     */
    public static boolean isEmpty(String src) {
        if (src != null && src.trim().length() > 0) {
            return false;
        }
        return true;
    }

    /**
     * 方法描述：判断字符串是否不为空
     *
     * @param src 字符串
     */
    public static boolean isNotEmpty(String src) {
        if (src == null && src.trim().length() == 0) {
            return false;
        }
        return true;
    }

    /**
     * 方法描述：判断字符串是否为数字
     *
     * @param src 字符串
     */
    public static boolean isNumbers(String src) {
        if (isNotEmpty(src)) {
            Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
            return pattern.matcher(src).matches();
        }
       return false;
    }

}
