package com.ai.utils;

import java.io.Serializable;

/**
 * 返回格式体
 * @Author zyz
 * @Date 2023/4/9 10:23
 */
public class R<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private String code = "0000";
    private String message = "";
    private T result;

    private R() {
    }

    private R(String message) {
        this.message = message;
    }

    private R(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private R(String code, String message, T result) {
        this.result = result;
        this.code = code;
        this.message = message;
    }

    public boolean isSuccess() {
        return "0000".equals(this.code);
    }

    public static R success() {
        return new R("成功");
    }

    public static R success(String message) {
        return new R(message);
    }

    public static <T> R success(T result) {
        return new R("0000", "成功", result);
    }

    public static R error() {
        return new R("9999", "失败");
    }

    public static R error(String message) {
        return new R("9999", message);
    }

    public static R error(String code, String message) {
        return new R(code, message);
    }

    public static R warn() {
        return new R("9998", "操作失败");
    }

    public static R warn(String message) {
        return new R("9998", message);
    }

    public static R warn(String code, String message) {
        return new R(code, message);
    }

    public static <T> R data(T result) {
        return new R("0000", "成功", result);
    }

    public static <T> R data(String message, T result) {
        return data("0000", message, result);
    }

    public static <T> R data(String code, String message, T result) {
        return new R(code, message, result);
    }

    public static <T> R toResult(int rows) {
        return rows > 0 ? success() : error();
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public T getResult() {
        return this.result;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof R)) {
            return false;
        } else {
            R<?> other = (R)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$code = this.getCode();
                    Object other$code = other.getCode();
                    if (this$code == null) {
                        if (other$code == null) {
                            break label47;
                        }
                    } else if (this$code.equals(other$code)) {
                        break label47;
                    }

                    return false;
                }

                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                Object this$result = this.getResult();
                Object other$result = other.getResult();
                if (this$result == null) {
                    if (other$result != null) {
                        return false;
                    }
                } else if (!this$result.equals(other$result)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof R;
    }

    public int hashCode() {
        int result = 1;
        Object $code = this.getCode();
        result = result * 59 + ($code == null ? 43 : $code.hashCode());
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        Object $result = this.getResult();
        result = result * 59 + ($result == null ? 43 : $result.hashCode());
        return result;
    }

    public String toString() {
        return "R(code=" + this.getCode() + ", message=" + this.getMessage() + ", result=" + this.getResult() + ")";
    }

}
