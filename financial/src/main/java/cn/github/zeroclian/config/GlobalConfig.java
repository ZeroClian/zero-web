package cn.github.zeroclian.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: qiyiguo
 * @Date: 2021-10-11 4:28 下午
 */
@Data
@Configuration
@RefreshScope
public class GlobalConfig {

    @Value("${spring.test}")
    private String appName;
}
