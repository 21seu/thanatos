package com.ai.controller;

import com.ai.service.OpenAiChatService;
import com.ai.utils.R;
import com.unfbx.chatgpt.OpenAiClient;
import com.unfbx.chatgpt.entity.completions.CompletionResponse;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Arrays;
import java.util.List;

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
    public R openAiChat(@RequestParam("question")String question){
        log.info("request params:{}", question);
        String text = openAiChatService.chat(question);
        return R.success(text);
    }

    @GetMapping("/img/create")
    public R openAiCreateImg(@RequestParam("description")String description) {
        log.info("request params:{}", description);
        List<String> imgUrls = openAiChatService.imgCreate(description);
        return R.success(imgUrls);
    }
}
