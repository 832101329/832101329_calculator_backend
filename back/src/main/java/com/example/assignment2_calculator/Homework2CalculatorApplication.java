package com.example.homework2_calculator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.homework2_calculator")
public class Homework2CalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(Homework2CalculatorApplication.class, args);
    }

}
