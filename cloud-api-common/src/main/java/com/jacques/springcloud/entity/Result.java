package com.jacques.springcloud.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jacques·Fry
 * @version 1.0
 * @info 返回数据
 * @note 文件说明
 * @date 2020/10/14 22:15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    @ApiModelProperty("状态码")
    private Integer code;
    @ApiModelProperty("访问提示信息")
    private String msg;
    @ApiModelProperty("返回数据")
    private T data;

    public Result(Integer code,String msg){
        this(code,msg,null);
    }
}
