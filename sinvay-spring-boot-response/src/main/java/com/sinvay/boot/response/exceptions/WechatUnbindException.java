package com.sinvay.boot.response.exceptions;

/**
 * 微信未绑定异常
 *
 * @author pizzalord
 * @since 1.0
 */
public class WechatUnbindException extends RuntimeException {
    private static final long serialVersionUID = -4431882967389008875L;

    public WechatUnbindException() {
    }

    public WechatUnbindException(String message) {
        super(message);
    }

    public WechatUnbindException(String message, Throwable cause) {
        super(message, cause);
    }

    public WechatUnbindException(Throwable cause) {
        super(cause);
    }

    public WechatUnbindException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
