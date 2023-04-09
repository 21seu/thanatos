package com.ai.service;

import java.util.List;

/**
 * Created by fengtj on 2023/4/2 16:38
 */
public interface OpenAiChatService {

    /**
     * 聊天功能
     * @param prompt
     * @return
     */
    String chat(String prompt);


    /**
     * 根据语言描述生成图片
     * @param description
     * @return
     */
    List<String> imgCreate(String description);
}
