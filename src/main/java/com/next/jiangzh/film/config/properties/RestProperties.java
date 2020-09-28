package com.next.jiangzh.film.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 类名称：token请求参数配置类
 * <p>
 * 创建人： Sunyi
 * 创建时间：2020/9/27 15:53
 *
 * @author Sunyi
 * @date 2020/9/27 15:53
 * @updateRemark 修改备注：token请求参数配置类
 */
@Data
@Configuration
@ConfigurationProperties(prefix = RestProperties.REST_PREFIX)
public class RestProperties {

    /**
     *  参数前缀
     */
    public static final String REST_PREFIX = "rest";
    /**
     *  是否开启
     */
    public boolean authOpen;

}
