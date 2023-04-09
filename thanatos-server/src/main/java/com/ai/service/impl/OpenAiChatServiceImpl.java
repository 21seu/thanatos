package com.ai.service.impl;

import com.ai.properties.OpenAiProperties;
import com.ai.service.OpenAiChatService;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import com.unfbx.chatgpt.OpenAiClient;
import com.unfbx.chatgpt.entity.completions.CompletionResponse;
import com.unfbx.chatgpt.entity.images.ImageResponse;
import com.unfbx.chatgpt.entity.images.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by fengtj on 2023/4/2 16:39
 */
@Slf4j
@Service
public class OpenAiChatServiceImpl implements OpenAiChatService {


    @Autowired
    private OpenAiClient openAiClient;


    @Override
    public String chat(String prompt) {
        CompletionResponse completions = openAiClient.completions(prompt);
        String text = completions.getChoices()[0].getText().trim();
        log.info("response:{}", text);
        return text;
    }

    @Override
    public List<String> imgCreate(String description) {
        ImageResponse imageResponse = openAiClient.genImages(description);
        List<String> imgUrls = imageResponse.getData().stream().map(Item::getUrl).collect(Collectors.toList());
        log.info("response: {}", imgUrls);
        return imgUrls;
    }
}
