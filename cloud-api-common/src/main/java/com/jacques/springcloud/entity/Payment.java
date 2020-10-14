package com.jacques.springcloud.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Jacques·Fry
 * @version 1.0
 * @info 支付信息
 * @note 文件说明
 * @date 2020/10/14 22:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    @ApiModelProperty("ID")
    private long id;
    @ApiModelProperty("流水号")
    private String serial;
}
