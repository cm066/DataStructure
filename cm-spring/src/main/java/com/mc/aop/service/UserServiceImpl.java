package com.mc.aop.service;

public class UserServiceImpl implements UserService{
    @Override
    public void save() {
//        int a = 10/0;
        System.out.println("保存数据");
    }

    @Override
    public void delete() {
        System.out.println("删除数据");
    }
}
