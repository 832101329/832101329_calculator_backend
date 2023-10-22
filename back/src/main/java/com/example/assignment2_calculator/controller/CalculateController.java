package com.example.homework2_calculator.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.homework2_calculator.bean.Calculator;
import com.example.homework2_calculator.mapper.CalculatorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cal")
public class CalculateController {

    @Autowired
    private CalculatorMapper calculatorMapper;

    @PostMapping("/save")
    public void saveResult(@RequestParam("expression") String expression, @RequestParam("ans") String ans) {
        long time = System.currentTimeMillis();
        calculatorMapper.insert(new Calculator(null,expression,ans,time));
    }

    @GetMapping("/get")
    public String getLast() {
        LambdaQueryWrapper<Calculator> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(Calculator::getTime);
        Calculator calculator = calculatorMapper.selectList(wrapper).get(0);
        return calculator.getResult();
    }

    @GetMapping("/history")
    public List<String> history() {
        LambdaQueryWrapper<Calculator> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(Calculator::getTime);
        List<Calculator> calculators = calculatorMapper.selectList(wrapper);
        List<String> results = new ArrayList<>();
        for (Calculator calculator : calculators) {
            String s = calculator.getExpression() + "=" + calculator.getResult();
            results.add(s);
        }
        return results;
    }
}
