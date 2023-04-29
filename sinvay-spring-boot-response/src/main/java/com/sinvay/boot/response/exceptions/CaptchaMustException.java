package com.sinvay.boot.response.exceptions;

/**
 * 必须要验证码,否则抛异常
 */
public class CaptchaMustException extends RuntimeException {

    private static final long serialVersionUID = -2966102970046234887L;

    public CaptchaMustException() {
    }

    public CaptchaMustException(String message) {
        super(message);
    }

    public CaptchaMustException(String message, Throwable cause) {
        super(message, cause);
    }

    public CaptchaMustException(Throwable cause) {
        super(cause);
    }

    public CaptchaMustException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
