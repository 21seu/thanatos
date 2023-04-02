package com.ai.config;

import com.ai.properties.OpenAiProperties;
import com.theokanning.openai.OpenAiService;
import com.unfbx.chatgpt.OpenAiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.time.Duration;

/**
 * Created by fengtj on 2023/4/2 16:35
 */
@Configuration
public class OpenAiConfiguration {

    @Autowired
    private OpenAiProperties openAiProperties;
    private static final String OPEN_API_HOST = "https://api.openai.com/";

    @Bean
    public OpenAiService openAiService(){
        return new OpenAiService(openAiProperties.getKey(), Duration.ofSeconds(openAiProperties.getRequestTimeout()));
    }

    @Bean
    public OpenAiClient openAiClient() {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(openAiProperties.getProxyHost(), openAiProperties.getProxyPort()));
        return OpenAiClient.builder()
                .apiKey(openAiProperties.getKey())
                .connectTimeout(10000)
                .writeTimeout(10000)
                .readTimeout(10000)
                .proxy(proxy)
                //.interceptor(Collections.singletonList(httpLoggingInterceptor))
                .apiHost(OPEN_API_HOST)
                .build();
    }

}
