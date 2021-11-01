package com.example.demo.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author cm
 * @create 2021/10/30-1:53 下午
 */
@Component
public class ChainPatternDemo {

    //通过容器自动注入进来
    @Autowired
    private List<AbstractHandler> abstractHandleList;

    private AbstractHandler abstractHandler;

    //spring注入后自动执行，责任链的对象连接起来
    @PostConstruct
    public void initializeChainFilter(){

        for(int i = 0;i<abstractHandleList.size();i++){
            if(i == 0){
                abstractHandler = abstractHandleList.get(0);
            }else{
                AbstractHandler currentHander = abstractHandleList.get(i - 1);
                AbstractHandler nextHander = abstractHandleList.get(i);
                currentHander.setNextHandler(nextHander);
            }
        }
    }

    //直接调用这个方法使用
    public String exec(String request, String response) {
        abstractHandler.filter(request, response);
        return response;
    }

    public AbstractHandler getAbstractHandler() {
        return abstractHandler;
    }

    public void setAbstractHandler(AbstractHandler abstractHandler) {
        this.abstractHandler = abstractHandler;
    }

}
