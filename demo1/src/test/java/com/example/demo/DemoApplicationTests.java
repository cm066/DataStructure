package com.example.demo;

import com.example.demo.handler.ChainPatternDemo;
import com.example.demo.strategy.FileTypeResolveEnum;
import com.example.demo.strategy.StrategyUseService;
import com.example.demo.strategy.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    StrategyUseService strategyUseService;

    @Autowired
    ChainPatternDemo chainPatternDemo;
    @Test
    void contextLoads() {

        /**
         * 策略模式可以在
         */
        strategyUseService.resolveFile(FileTypeResolveEnum.File_A_RESOLVE,new User(12,"'chenm"));
        String exec = chainPatternDemo.exec("hh", "xixi");
        System.out.println(exec);
    }

}
