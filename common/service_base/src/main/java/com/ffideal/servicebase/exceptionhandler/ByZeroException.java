package com.ffideal.servicebase.exceptionhandler;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: ffideal
 * @CreateTime: 2022-08-18  22:41
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@AllArgsConstructor // 生成有参构造器
@NoArgsConstructor  // 生成无参构造器
public class ByZeroException extends RuntimeException{
    @ApiModelProperty(value = "状态码")
    private Integer code;
    private String msg;
}
