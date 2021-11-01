package com.mc.jdproxy;

/**
 * @author cm
 * @create 2021/10/23-4:12 下午
 */
public class ProxyTest {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        MyInvoationHandler invoationHandler = new MyInvoationHandler(userService);

        UserService proxy = (UserService) invoationHandler.getProxy();
        proxy.add();
    }
}
