package org.cassell.veikozz.common.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"org.cassell.veikozz.common"})
@EnableConfigurationProperties(CommonConfigProperties.class)
@Configuration
public class CommonConfig {

    public CommonConfig(CommonConfigProperties commonConfigProperties) {
        if (commonConfigProperties == null) {
        }
    }

}
