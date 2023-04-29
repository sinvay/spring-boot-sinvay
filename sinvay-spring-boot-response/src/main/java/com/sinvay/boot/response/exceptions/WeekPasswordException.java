package com.sinvay.boot.response.exceptions;

/**
 * 弱密码异常
 */
public class WeekPasswordException extends RuntimeException {

    private static final long serialVersionUID = 2407958300157751709L;

    public WeekPasswordException() {
    }

    public WeekPasswordException(String message) {
        super(message);
    }

    public WeekPasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeekPasswordException(Throwable cause) {
        super(cause);
    }

    public WeekPasswordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
