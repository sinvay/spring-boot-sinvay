package com.sinvay.boot.response;

import com.sinvay.boot.response.exceptions.UnknownResponseCodeException;
import lombok.Getter;

/**
 * 自定义返回
 * 后续拓展支持动态配置
 *
 * @author pizzalord
 * @since 1.0
 */
public enum ResponseCode {
    SUCCESS(0, "操作成功"),
    FAILED(-1, "操作失败"),
    WARNING(-2, "告警"),
    ILLEGAL_REQ(1, "请求非法"),
    ILLEGAL_RESP(2, "返回非法"),
    CAPTCHA_MUST(100, "需要验证码"),
    WEEK_PASSWORD(101, "密码强度低"),
    EMAIL_MUST(102, "需要强制绑定邮箱"),
    UNAUTHORIZED(401, "授权无效或过期"),
    FORBIDDEN(403, "资源访问受限"),
    WECHAT_UNBIND(410, "微信未绑定"),
    INTERNAL_SERVER_ERROR(500, "服务内部错误"),
    SERVICE_UNAVAILABLE(503, "服务不可用"),
    FAILED_REFRESH_TOKEN(1401, "授权刷新无效,请重新登录");

    @Getter
    private int code;
    @Getter
    private String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过code找打错误码枚举
     *
     * @param code
     * @return
     */
    public static ResponseCode codeOf(int code) {
        for (ResponseCode responseCode : values()) {
            if (responseCode.code == code) {
                return responseCode;
            }
        }
        throw new UnknownResponseCodeException("未捕获到的状态码:" + code);
    }
}
