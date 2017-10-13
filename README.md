## oss-starter

> 意在简化OSS存储配置，并引入自己封装的`storageApi`，轻松接入阿里云对象存储！

### 本项目依赖：

> `spring-boot` 自动配置依赖

```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-autoconfigure</artifactId>
    </dependency>
```

> 存储操作依赖（以下简称storageApi）

```xml
    <dependency>
        <groupId>com.luckysweetheart.starter</groupId>
        <artifactId>storage</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>
```

> 由于存储storageApi 依赖aliyun-oss-sdk ，每次spring容器启动之前，必须初始化`OSSClient`对象，通过本项目，可在spring-boot项目中简单的使用OSS存储

### example

1. 引入starter

```xml
    <dependency>
        <groupId>com.luckysweetheart.starter</groupId>
        <artifactId>oss-starter</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>
```

2. `application.xml` or `application.yaml` 文件：

```yml
spring:
  oss :
    endpoint : oss-cn-beijing.aliyuncs.com
    accessKeyId : LTAI5AZC3EzQyaSv
    secretAccessKey : LxsRHeOECzxWZPc3F1wkAIGHGtMNlk
```

> 注意：如果不指定上面的内容，将会默认以上配置。

3. 开始使用

```java
    @Resource
    private StorageApi storageApi;

    @Test
    public void contextLoads() throws StorageException {
        System.out.println(storageApi.groupList()); // 输出组列表
    }
```