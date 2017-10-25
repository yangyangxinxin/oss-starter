package com.luckysweetheart.starter.ossstarter.autoconfigure;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.OSSClient;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yangxin on 2017/9/30.
 */
@Configuration
@ConditionalOnClass(OSSClient.class) // 只有在ClassPath中存在OSSClient的时候会加载本类下的bean
@EnableConfigurationProperties(OSSProperties.class) // 配置类
@ComponentScan({"com.luckysweetheart.storage"}) // 扫描包
public class OSSAutoconfigure {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private OSSProperties ossProperties;

    @Bean
    @ConditionalOnMissingBean // 当spring-context 中不存在这个bean的时候，则会加载该bean。
    //@ConditionalOnProperty(prefix = "spring.oss",value = "enabled",havingValue = "true") // example.service.enabled=true 只有配置了这个才会装配这个bean
    public OSSClient ossClient() {
        logger.info("初始化阿里云OSS客户端 at {}", formatDate());
        ClientConfiguration configuration = new ClientConfiguration();
        configuration.setMaxConnections(ossProperties.getMaxConnections());
        configuration.setMaxErrorRetry(ossProperties.getMaxErrorRetry());
        configuration.setSocketTimeout(ossProperties.getSocketTimeout());
        logger.info("客户端最大连接数为: {} , 最大重试次数为: {} , 通过打开的连接传输数据的超时时间为: {}ms。 ", ossProperties.getMaxConnections(), ossProperties.getMaxErrorRetry(), ossProperties.getSocketTimeout());

        OSSClient ossClient = new OSSClient(ossProperties.getEndpoint(), ossProperties.getAccessKeyId(), ossProperties.getSecretAccessKey(), configuration);
        logger.info("初始化阿里云OSS客户端完成 at {}", formatDate());
        return ossClient;
    }

    /**
     * 没有任何的Condition，表示始终都会加载该bean。
     *
     * @return
     */
    @Bean
    public String testStr() {
        return ossProperties.getAccessKeyId();
    }

    private String formatDate() {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return simpleDateFormat.format(new Date());
        } catch (Exception e) {
            return null;
        }
    }
}
