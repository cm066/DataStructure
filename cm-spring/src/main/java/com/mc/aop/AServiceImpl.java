package com.mc.aop;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

/**
 * @author cm
 * @create 2021/10/23-3:49 下午
 */

@Service
public class AServiceImpl implements AService{


    @Override
    public void a() {
        ((AService) AopContext.currentProxy()).b();//这样在这个方法里面才会有效
    }

    @Override
    public void b() {

    }
}
