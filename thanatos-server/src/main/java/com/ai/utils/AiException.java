package com.ai.utils;

/**
 * 业务流程错误请抛出此异常
 * @Author zyz
 * @Date 2023/4/9 10:26
 */
public class AiException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String code;
    private String message;

    public AiException(String message) {
        this.message = message;
    }

    public AiException(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public AiException(String message, Throwable e) {
        super(message, e);
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return this.code;
    }

}
