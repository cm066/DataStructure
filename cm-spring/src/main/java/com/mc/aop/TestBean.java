package com.mc.aop;

/**
 * @author cm
 * @create 2021/10/23-3:33 下午
 */
public class TestBean {

    private String testStr = "testStr";

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }
    public void test(){
        System.out.println("test");
    }
}
