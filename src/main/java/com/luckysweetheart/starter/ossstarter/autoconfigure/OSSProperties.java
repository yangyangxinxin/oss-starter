package com.luckysweetheart.starter.ossstarter.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by yangxin on 2017/9/30.
 */
@ConfigurationProperties(prefix = "spring.oss")
public class OSSProperties {

    private String endpoint = "oss-cn-beijing.aliyuncs.com";

    private String accessKeyId = "LTAI5AZC3EzQyaSv";

    private String secretAccessKey = "LxsRHeOECzxWZPc3F1wkAIGHGtMNlk";

    private int maxConnections = 200;

    private int socketTimeout = 10000;

    private int maxErrorRetry = 3;

    public int getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    public int getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public int getMaxErrorRetry() {
        return maxErrorRetry;
    }

    public void setMaxErrorRetry(int maxErrorRetry) {
        this.maxErrorRetry = maxErrorRetry;
    }

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
