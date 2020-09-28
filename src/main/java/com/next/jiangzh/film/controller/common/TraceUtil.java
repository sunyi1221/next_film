package com.next.jiangzh.film.controller.common;

/**
 * 类名称：视图对象处理工具类
 *
 * 创建人： Sunyi
 * 创建时间：2020/9/26 17:42
 *
 * @author Sunyi
 * @date 2020/9/26 17:42
 * @updateRemark 修改备注：视图对象处理工具类
 */
public final class TraceUtil {

    private TraceUtil(){}

    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void initThread(String userId) {
        threadLocal.set(userId);
    }

    public static String getUserId() {
        return threadLocal.get();
    }

}
