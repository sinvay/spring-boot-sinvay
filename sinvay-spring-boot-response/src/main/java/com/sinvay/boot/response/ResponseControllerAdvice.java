package com.sinvay.boot.response;

import com.sinvay.boot.response.exceptions.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Response advice
 *
 * @author pizzalord
 * @since 1.0
 */
@Slf4j
@RestControllerAdvice
public class ResponseControllerAdvice {
    /**
     * 服务不可用
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(ServiceUnavailableException.class)
    public Response handleInternalServerException(ServiceUnavailableException ex) {
        log.error(ResponseCode.SERVICE_UNAVAILABLE + ":" + ex.getMessage());
        return Response.failWith(ResponseCode.SERVICE_UNAVAILABLE);
    }

    /**
     * 内部服务错误
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(InternalServerException.class)
    public Response handleInternalServerException(InternalServerException ex) {
        log.error(ResponseCode.INTERNAL_SERVER_ERROR + ":" + ex.getMessage());
        return Response.failWith(ResponseCode.INTERNAL_SERVER_ERROR);
    }

    /**
     * 捕获未处理的异常 code:401
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(UnauthorizedException.class)
    public Response handleUnauthorizedException(UnauthorizedException ex) {
        log.error(ResponseCode.UNAUTHORIZED + ":" + ex.getMessage());
        return Response.failWith(ResponseCode.UNAUTHORIZED);
    }

    /**
     * 捕获未处理的异常 code:403
     *
     * @param ex 异常
     * @return 返回
     */
    @ExceptionHandler(ForbiddenException.class)
    public Response handleForbiddenException(ForbiddenException ex) {
        log.error(ResponseCode.FORBIDDEN + ":" + ex.getMessage());
        return Response.failWith(ResponseCode.FORBIDDEN);
    }

    /**
     * 捕获未处理的异常 code:410
     *
     * @param ex 异常
     * @return 返回
     */
    @ExceptionHandler(WechatUnbindException.class)
    public Response handleForbiddenException(WechatUnbindException ex) {
        log.error(ResponseCode.WECHAT_UNBIND + ":" + ex.getMessage());
        return Response.failWith(ResponseCode.WECHAT_UNBIND);
    }

    /**
     * 校验返回问题 code:1
     *
     * @param ex 异常
     * @return 返回
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response handleParamException(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        String friendlyMessage = String.format("参数{%s}%s", fieldError.getField(), fieldError.getDefaultMessage());
        log.error(ResponseCode.ILLEGAL_REQ.getMessage() + ":" + fieldError);
        return Response.failWith(ResponseCode.ILLEGAL_REQ.getCode(), friendlyMessage);
    }

    @ExceptionHandler({HttpMessageNotReadableException.class, IllegalRequestException.class})
    public Response handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        log.error(ex.getMessage(), ex);
        return Response.failWith(ResponseCode.ILLEGAL_REQ);
    }

    /**
     * 校验返回问题 code:2
     *
     * @param ex 异常
     * @return 返回
     */
    @ExceptionHandler(BindException.class)
    public Response handleRespException(BindException ex) {
        FieldError fieldError = ex.getFieldError();
        String friendlyMessage = String.format("参数{%s}%s", fieldError.getField(), fieldError.getDefaultMessage());
        log.error(ResponseCode.ILLEGAL_RESP.getMessage() + ":" + fieldError);
        return Response.failWith(ResponseCode.ILLEGAL_RESP.getCode(), friendlyMessage);
    }

    /**
     * 告警 code:-2
     *
     * @param ex 异常
     * @return 返回
     */
    @ExceptionHandler(WarningException.class)
    public Response handleWarningException(Exception ex) {
        log.warn(ex.getMessage());
        return Response.failWith(ResponseCode.WARNING.getCode(), ex.getMessage());
    }

    /**
     * 缺少验证码
     *
     * @param ex 异常
     * @return 返回
     */
    @ExceptionHandler(CaptchaMustException.class)
    public Response captchaMustException(Exception ex) {
        log.warn(ResponseCode.CAPTCHA_MUST.getMessage());
        return Response.failWith(ResponseCode.CAPTCHA_MUST);
    }

    /**
     * 密码强度低
     *
     * @param ex 异常
     * @return 返回
     */
    @ExceptionHandler(WeekPasswordException.class)
    public Response weekPasswordException(Exception ex) {
        log.warn(ResponseCode.WEEK_PASSWORD.getMessage());
        return Response.failWith(ResponseCode.WEEK_PASSWORD);
    }

    /**
     * 邮箱缺失
     *
     * @param ex 异常
     * @return 返回
     */
    @ExceptionHandler(EmailMustException.class)
    public Response emailMustException(Exception ex) {
        log.warn(ResponseCode.EMAIL_MUST.getMessage());
        return Response.failWith(ResponseCode.EMAIL_MUST);
    }

    /**
     * 捕获未处理的异常 code:-1
     *
     * @param ex 异常
     * @return 返回
     */
    @ExceptionHandler(Exception.class)
    public Response handleCustomerException(Exception ex) {
        log.error(ex.getMessage(), ex);
        return Response.fail(StringUtils.isNotEmpty(ex.getMessage()) ? ex.getMessage() : ResponseCode.FAILED.getMessage());
    }

}
