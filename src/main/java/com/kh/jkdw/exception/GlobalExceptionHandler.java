package com.kh.jkdw.exception;

import com.kh.jkdw.enums.StatusCodeEnum;
import com.kh.jkdw.model.vo.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;




@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 处理空指针的异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public ResponseResult exceptionHandler(HttpServletRequest req, NullPointerException e){
        log.error("发生空指针异常！原因是:",e);
        return ResponseResult.failure(
                StatusCodeEnum.PARAM_ERROR.getCode(),
                e.getMessage());
    }

    @ExceptionHandler(value = IllegalStateException.class)
    @ResponseBody
    public ResponseResult exceptionHandler(HttpServletRequest req, IllegalStateException e){
        log.error("非法状态异常！原因是:",e);
        return ResponseResult.failure(
                StatusCodeEnum.ILLEG_STATUS.getCode(),
                e.getMessage());
    }

    /**
     * 数字转换异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = NumberFormatException.class)
    @ResponseBody
    public ResponseResult exceptionHandler(HttpServletRequest req, NumberFormatException e){
        log.error("数字转换异常！原因是:",e);
        return ResponseResult.failure(
                StatusCodeEnum.NUMBER_FORMAT.getCode(),
                e.getMessage());
    }

    /**
     * 拦截业务类异常
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public ResponseResult businessExceptionHandle(BusinessException e) {
        log.error("捕捉到业务类异常：", e);
        return ResponseResult.failure(e.getCode(), e.getMessage());
    }


    /**
     * 拦截运行时异常
     * @param e
     */
    @ResponseBody
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseResult runtimeExceptionHandle(RuntimeException e) {
        log.error("捕捉到运行时异常：", e);
        return ResponseResult.failure(
                StatusCodeEnum.UNKNOWN_ERROR.getCode(),
                e.getMessage());
    }

    /**
     * 捕捉系统级异常
     * @param th
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Throwable.class)
    public ResponseResult throwableHandle(Throwable th) {
        log.error("捕捉Throwable异常：", th);
        return ResponseResult.failure(
                StatusCodeEnum.SYSTEM_ERROR.getCode(),
                th.getMessage());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseResult throwableHandle(MethodArgumentNotValidException e) {
        log.error("捕捉MethodArgumentNotValidException异常：", e);
        FieldError fieldError = e.getBindingResult().getFieldError();
        if (fieldError != null){
            return ResponseResult.failure(
                    StatusCodeEnum.PARAM_ERROR.getCode(),
                    fieldError.getDefaultMessage());
        }else {
            return ResponseResult.failure(
                    StatusCodeEnum.PARAM_ERROR.getCode(),
                    e.getMessage());
        }
    }
}
