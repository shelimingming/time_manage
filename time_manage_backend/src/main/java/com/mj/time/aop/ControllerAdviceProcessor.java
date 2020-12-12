package com.mj.time.aop;

import com.mj.time.common.BizException;
import com.mj.time.common.CommonResponse;
import com.mj.time.common.ErrorCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 统一处理Controller中的异常
 *
 * @author sheliming
 * @date 2020-05-22
 */
@ControllerAdvice
@Slf4j
public class ControllerAdviceProcessor {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonResponse<Object> handleException(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        log.error("{}", ex);
        if (ex instanceof BizException) {
            BizException bizException = (BizException) ex;
            response.setStatus(HttpStatus.OK.value());
            return new CommonResponse<Object>(bizException.getErrorCode(), bizException.getErrorMsg());
        } else {
            response.setStatus(HttpStatus.OK.value());
            return new CommonResponse<Object>(ErrorCodeEnum.UNKNOW_ERROR.getCode(), ErrorCodeEnum.UNKNOW_ERROR.getMsg());
        }
    }
}