package com.example.homework2_calculator.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@TableName("tb_calculator")
public class Calculator {

    @TableId(type = IdType.NONE)
    private Long id;

    private String expression;

    private String result;

    private Long time;
}
