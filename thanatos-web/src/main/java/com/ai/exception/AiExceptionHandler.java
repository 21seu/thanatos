package com.ai.exception;

import com.ai.utils.AiException;
import com.ai.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理类
 * @Author zyz
 * @Date 2023/4/9 10:35
 */
@Slf4j
@RestControllerAdvice
public class AiExceptionHandler {

    /**
     * 业务异常统一处理
     * @param e
     * @return
     */
    @ExceptionHandler(AiException.class)
    public R aiExceptionHandler(AiException e) {
        log.error("error msg:{}", e.getMessage());
        return R.error(e.getCode(), e.getMessage());
    }

    /**
     * 系统异常统一处理
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public R normalExceptionHandler(Exception e) {
        log.error("error msg:{}", e.getMessage());
        return R.error(e.getMessage());
    }



}
