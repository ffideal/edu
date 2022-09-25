package com.ffideal.servicebase.exceptionhandler;

/**
 * @Author: ffideal
 * @CreateTime: 2022-08-18  17:20
 * @Description: TODO
 * @Version: 1.0
 */


import com.ffideal.servicebase.commonutils.R;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理类
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
        e.printStackTrace();
        return R.error().message("全局异常处理。。。。");
    }

    @ApiOperation("特殊异常处理")
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R error(ArithmeticException e){
        e.printStackTrace();
        return R.error().message("ArithmeticException 异常处理。。。。");
    }

    @ApiOperation("特殊异常处理")
    @ExceptionHandler(ByZeroException.class)
    @ResponseBody
    public R error(ByZeroException e){
        log.error(e.getMessage());
        e.printStackTrace();
        return R.error().message("ByZeroException自定义异常处理。。。。"+e.getMsg()).code(e.getCode());
    }
}