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
@ConditionalOnClass(OSSClient.class) // 只有在ClassPath中存在OSSClient的时候会加载本类下的bean
@EnableConfigurationProperties(OSSProperties.class) // 配置类
@ComponentScan({"com.luckysweetheart.storage"}) // 扫描包
public class OSSAutoconfigure {

    @Resource
    private OSSProperties ossProperties;

    @Bean
    @ConditionalOnMissingBean // 当spring-context 中不存在这个bean的时候，则会加载该bean。
    //@ConditionalOnProperty(prefix = "spring.oss",value = "enabled",havingValue = "true") // example.service.enabled=true 只有配置了这个才会装配这个bean
    public OSSClient ossClient(){
        return new OSSClient(ossProperties.getEndpoint(),ossProperties.getAccessKeyId(),ossProperties.getSecretAccessKey());
    }

    /**
     * 没有任何的Condition，表示始终都会加载该bean。
     * @return
     */
    @Bean
    public String testStr(){
        return ossProperties.getAccessKeyId();
    }
}
