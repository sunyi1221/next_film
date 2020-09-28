package com.next.jiangzh.film.config;

import com.next.jiangzh.film.config.properties.RestProperties;
import com.next.jiangzh.film.controller.common.filter.AuthFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 类名称：jwt token的配置类
 * <p>
 * 创建人： Sunyi
 * 创建时间：2020/9/27 15:44
 *
 * @author Sunyi
 * @date 2020/9/27 15:44
 * @updateRemark 修改备注：jwt token的配置类
 */
@Configuration
public class WebConfig {

    @Bean
    @ConditionalOnProperty(prefix = RestProperties.REST_PREFIX, name = "auth-open", havingValue = "true", matchIfMissing = true)
    public AuthFilter jwtAuthenticationTokenFilter() {
        return new AuthFilter();
    }

}
