package com.luckysweetheart.starter.ossstarter.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by yangxin on 2017/9/30.
 */
@ConfigurationProperties("spring.oss")
public class OSSProperties {

    private String endpoint = "oss-cn-beijing.aliyuncs.com";

    private String accessKeyId = "LTAI5AZC3EzQyaSv";

    private String secretAccessKey = "LxsRHeOECzxWZPc3F1wkAIGHGtMNlk";

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getSecretAccessKey() {
        return secretAccessKey;
    }

    public void setSecretAccessKey(String secretAccessKey) {
        this.secretAccessKey = secretAccessKey;
    }
}
