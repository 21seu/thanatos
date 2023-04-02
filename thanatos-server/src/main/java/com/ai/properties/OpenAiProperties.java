package com.ai.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zyz
 * @Date 2023/4/2 19:16
 */

@Data
@Configuration
@ConfigurationProperties("open.ai")
public class OpenAiProperties {

    /**
     * open api 账号权限认证key
     */
    private String key = "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";
    /**
     * 请求open api超时时间
     */
    private Integer requestTimeout = 10000;

    private String model = "text-davinci-003";

    private String proxyHost = "localhost";

    private Integer proxyPort = 15732;



}
