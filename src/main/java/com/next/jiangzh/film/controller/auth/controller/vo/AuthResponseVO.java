package com.next.jiangzh.film.controller.auth.controller.vo;

import com.next.jiangzh.film.controller.common.BaseVO;
import com.next.jiangzh.film.controller.exception.ParamErrorException;
import lombok.Builder;
import lombok.Data;

/**
 * 类名称：jwt验证响应VO
 * <p>
 * 创建人： Sunyi
 * 创建时间：2020/9/27 13:40
 *
 * @author Sunyi
 * @date 2020/9/27 13:40
 * @updateRemark 修改备注：jwt验证响应VO
 */
@Data
@Builder
public class AuthResponseVO extends BaseVO {

    /**
     * 随机密钥
     */
    private String randomKey;
    /**
     * 响应token
     */
    private String token;

    /**
     * 参数校验
     */
    @Override
    public void checkParam() throws ParamErrorException {

    }

}
