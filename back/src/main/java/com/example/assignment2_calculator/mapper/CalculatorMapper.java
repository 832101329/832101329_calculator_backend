package com.example.homework2_calculator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.homework2_calculator.bean.Calculator;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CalculatorMapper extends BaseMapper<Calculator> {
}
