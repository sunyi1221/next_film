package com.next.jiangzh.film.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 类名称：jwt参数配置类
 *
 * 创建人： Sunyi
 * 创建时间：2020/9/27 13:33
 *
 * @author Sunyi
 * @date 2020/9/27 13:33
 * @updateRemark 修改备注：jwt参数配置类
 */
@Data
@Configuration
@ConfigurationProperties(prefix = JwtProperties.JWT_PREFIX)
public class JwtProperties {

    public static final String JWT_PREFIX = "jwt";

    private String header = "Authorization";

    private String secret = "defaultSecret";

    private Long expiration = 604800L;

    private String md5Key = "randomKey";

}
