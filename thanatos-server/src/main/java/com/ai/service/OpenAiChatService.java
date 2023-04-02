package com.ai.service;

/**
 * Created by fengtj on 2023/4/2 16:38
 */
public interface OpenAiChatService {

    /**
     * chat
     * @param prompt
     * @return
     */
    String chat(String prompt);
}
