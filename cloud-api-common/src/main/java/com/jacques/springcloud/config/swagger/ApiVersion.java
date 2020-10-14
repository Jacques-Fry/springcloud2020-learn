package com.jacques.springcloud.config.swagger;

import java.lang.annotation.*;

/**
 * @author Jacques·Fry
 * @version 2.2.7
 * @info api文档版本号
 * @date 2020/10/13 9:21
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface ApiVersion {
    /**
     * 接口版本号(对应swagger中的group)
     * @return String[]
     */
    String[] group() default {ApiVersionConstant.V1_0_0};
}
