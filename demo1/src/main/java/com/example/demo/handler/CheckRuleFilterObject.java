package com.example.demo.handler;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author cm
 * @create 2021/10/30-1:48 下午
 */

@Component
@Order(4)
public class CheckRuleFilterObject extends AbstractHandler{

    @Override
    void doFilter(String filterRequest, String response) {
        System.out.println("check rule");
    }
}
