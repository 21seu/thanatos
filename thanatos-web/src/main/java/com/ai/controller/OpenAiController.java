package com.ai.controller;

import com.ai.service.OpenAiChatService;
import com.unfbx.chatgpt.OpenAiClient;
import com.unfbx.chatgpt.entity.completions.CompletionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/chat")
    public String openAiChat(@RequestParam("question")String question){
        log.info("question:{}", question);
        return openAiChatService.chat(question);
    }
}
