package com.jacques.springcloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jacques.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Jacques·Fry
 * @version 1.0
 * @info 文件业务
 * @note 文件说明
 * @date 2020/10/14 22:18
 */
@Mapper
public interface PaymentMapper extends BaseMapper<Payment> {
}
