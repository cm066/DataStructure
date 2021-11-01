package com.example.demo.strategy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author cm
 * @create 2021/10/30-12:15 下午
 */

@Component
public class StrategyUseService implements ApplicationContextAware {

    private Map<FileTypeResolveEnum, IFileStrategy> iFileStrategyMap = new ConcurrentHashMap<>();

    public void resolveFile(FileTypeResolveEnum fileTypeResolveEnum, Object objectParam) {
        IFileStrategy iFileStrategy = iFileStrategyMap.get(fileTypeResolveEnum);
        if (iFileStrategy != null) {
            iFileStrategy.resolve(objectParam);
        }
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, IFileStrategy> tmepMap = applicationContext.getBeansOfType(IFileStrategy.class);
        tmepMap.values().forEach(strategyService -> iFileStrategyMap.put(strategyService.gainFileType(), strategyService));
    }
}
