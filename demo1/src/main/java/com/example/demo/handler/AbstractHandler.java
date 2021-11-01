package com.example.demo.handler;

/**
 * @author cm
 * @create 2021/10/30-1:40 下午
 */
public abstract class AbstractHandler {
    private AbstractHandler nextHandler;
    /**
     * 责任链的下一个对象
     */
    public void setNextHandler(AbstractHandler nextHandler){
        this.nextHandler = nextHandler;
    }

    /**
     * 具体参数拦截逻辑,给子类去实现
     */
    public void filter(String request, String response) {
        doFilter(request, response);
        if (getNextHandler() != null) {
            getNextHandler().filter(request, response);
        }
    }

    public AbstractHandler getNextHandler() {
        return nextHandler;
    }

    abstract void doFilter(String filterRequest, String response);
}
