package com.ai.controller;

import com.ai.service.OpenAiChatService;
import com.unfbx.chatgpt.OpenAiClient;
import com.unfbx.chatgpt.entity.completions.CompletionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Arrays;

/**
 * Created by fengtj on 2023/4/2 16:45
 */
@Slf4j
@RestController
@RequestMapping("/openAi")
public class OpenAiController {

    @Autowired
    private OpenAiChatService openAiChatService;

    @RequestMapping("/test")
    public String test(){
        return "hello";
    }

    @RequestMapping("/chat")
    public String openAiChat(@RequestParam("question")String question){
        return openAiChatService.chat(question);
    }


    public static void main(String[] args) {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("localhost", 15732));
        OpenAiClient openAiClient = OpenAiClient.builder()
                .apiKey("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")
                .connectTimeout(50)
                .writeTimeout(50)
                .readTimeout(50)
                .proxy(proxy)
                //.interceptor(Collections.singletonList(httpLoggingInterceptor))
                .apiHost("https://api.openai.com/")
                .build();
        CompletionResponse completions = openAiClient.completions("用java写一段快速排序");
        Arrays.stream(completions.getChoices()).forEach(System.out::println);
    }
}
