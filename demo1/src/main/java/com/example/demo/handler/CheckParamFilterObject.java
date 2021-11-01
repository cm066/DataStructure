package com.example.demo.handler;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author cm
 * @create 2021/10/30-1:47 下午
 */
@Component
@Order(1)
public class CheckParamFilterObject extends AbstractHandler{

    @Override
    void doFilter(String filterRequest, String response) {
        System.out.println("非空参数检查");
    }
}
