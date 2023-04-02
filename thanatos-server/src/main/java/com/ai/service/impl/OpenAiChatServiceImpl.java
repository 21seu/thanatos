package com.ai.service.impl;

import com.ai.service.OpenAiChatService;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by fengtj on 2023/4/2 16:39
 */
@Slf4j
@Service
public class OpenAiChatServiceImpl implements OpenAiChatService {

    @Value("${open.ai.model}")
    private String openAiModel;
    @Autowired
    private OpenAiService openAiService;


    @Override
    public String chat(String prompt) {
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt(prompt)
                .model(openAiModel)
                .echo(true)
                .temperature(0.7)
                .topP(1d)
                .frequencyPenalty(0d)
                .presencePenalty(0d)
                .maxTokens(1000)
                .build();
        CompletionResult completionResult = openAiService.createCompletion(completionRequest);
        String text = completionResult.getChoices().get(0).getText();
        return text;
    }
}
