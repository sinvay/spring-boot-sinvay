package com.sinvay.boot.response.exceptions;

/**
 * 必须绑定邮箱,否则抛异常
 */
public class EmailMustException extends RuntimeException {

    private static final long serialVersionUID = -4065030685240275065L;

    public EmailMustException() {
    }

    public EmailMustException(String message) {
        super(message);
    }

    public EmailMustException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailMustException(Throwable cause) {
        super(cause);
    }

    public EmailMustException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
