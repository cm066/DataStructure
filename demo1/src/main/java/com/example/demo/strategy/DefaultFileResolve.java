package com.example.demo.strategy;

import org.springframework.stereotype.Component;

/**
 * @author cm
 * @create 2021/10/30-12:13 下午
 */
@Component
public class DefaultFileResolve implements IFileStrategy{
    @Override
    public FileTypeResolveEnum gainFileType() {
        return FileTypeResolveEnum.File_DEFAULT_RESOLVE;
    }

    @Override
    public void resolve(Object objectparam) {
        System.out.println("采用的是默认的解析文件的方法，参数是："+objectparam);
    }
}
