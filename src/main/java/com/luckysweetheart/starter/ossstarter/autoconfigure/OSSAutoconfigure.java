package com.luckysweetheart.starter.ossstarter.autoconfigure;

import com.aliyun.oss.OSSClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * Created by yangxin on 2017/9/30.
 */
@Configuration
@ConditionalOnClass(OSSClient.class)
@EnableConfigurationProperties(OSSProperties.class)
@ComponentScan({"com.luckysweetheart.storage"})
public class OSSAutoconfigure {

    @Resource
    private OSSProperties ossProperties;

    @Bean
    @ConditionalOnMissingBean
    //@ConditionalOnProperty(prefix = "spring.oss",value = "enabled",havingValue = "true") // example.service.enabled=true 只有配置了这个才会装配这个bean
    OSSClient ossClient(){
        return new OSSClient(ossProperties.getEndpoint(),ossProperties.getAccessKeyId(),ossProperties.getSecretAccessKey());
    }
}
