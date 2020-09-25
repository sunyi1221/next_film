package com.next.jiangzh.film.controller.common;

import lombok.Data;

/**
 * 类名称：通用返回工具类
 *
 * 创建人： Sunyi
 * 创建时间：2020/9/25 9:12
 *
 * @author Sunyi
 * @date 2020/9/25 9:12
 * @updateRemark 修改备注：通用返回工具类
 */
@Data
public final class BaseResponseVO<M> {

    /**
     * 构造器私有化，不可实例化
     */
    private BaseResponseVO(){}

    /**
     *  返回状态[0-成功，1-业务失败，700-用户未登录，999-系统异常]
     */
    private int status;
    /**
     *  返回消息
     */
    private String msg;
    /**
     *  返回数据实体
     */
    private M data;
    /**
     *  图片前缀
     */
    private String imgPre;
    /**
     *  当前页数
     */
    private int nowPage;
    /**
     *  总页数
     */
    private int totalPage;


    public static<M> BaseResponseVO success() {
        BaseResponseVO responseVo = new BaseResponseVO();
        responseVo.setStatus(0);
        return responseVo;
    }

    public static<M> BaseResponseVO success(String msg) {
        BaseResponseVO responseVo = new BaseResponseVO();
        responseVo.setStatus(0);
        responseVo.setMsg(msg);
        return responseVo;
    }

    public static<M> BaseResponseVO success(M data) {
        BaseResponseVO responseVo = new BaseResponseVO();
        responseVo.setStatus(0);
        responseVo.setData(data);
        return responseVo;
    }

    public static<M> BaseResponseVO success(int nowPage, int totalPage, String imgPre, M data) {
        BaseResponseVO responseVo = new BaseResponseVO();
        responseVo.setStatus(0);
        responseVo.setNowPage(nowPage);
        responseVo.setTotalPage(totalPage);
        responseVo.setImgPre(imgPre);
        responseVo.setData(data);
        return responseVo;
    }

    public static<M> BaseResponseVO success(String imgPre, M data) {
        BaseResponseVO responseVo = new BaseResponseVO();
        responseVo.setStatus(0);
        responseVo.setImgPre(imgPre);
        responseVo.setData(data);
        return responseVo;
    }

    public static<M> BaseResponseVO noLogin() {
        BaseResponseVO responseVo = new BaseResponseVO();
        responseVo.setStatus(700);
        responseVo.setMsg("用户需要登录！");
        return responseVo;
    }

    public static<M> BaseResponseVO serviceFailed(String msg) {
        BaseResponseVO responseVo = new BaseResponseVO();
        responseVo.setStatus(1);
        responseVo.setMsg(msg);
        return responseVo;
    }

    public static<M> BaseResponseVO serviceFailed(String msg, M data) {
        BaseResponseVO responseVo = new BaseResponseVO();
        responseVo.setStatus(1);
        responseVo.setMsg(msg);
        responseVo.setData(data);
        return responseVo;
    }

    public static<M> BaseResponseVO systemError() {
        BaseResponseVO responseVo = new BaseResponseVO();
        responseVo.setStatus(999);
        responseVo.setMsg("系统错误，请联系管理员！");
        return responseVo;
    }

}
