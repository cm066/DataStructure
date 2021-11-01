package com.example.demo.strategy;

import org.springframework.stereotype.Component;

/**
 * @author cm
 * @create 2021/10/30-12:09 下午
 */
@Component
public class CFileResolve implements IFileStrategy{
    @Override
    public FileTypeResolveEnum gainFileType() {
        return FileTypeResolveEnum.File_C_RESOLVE;
    }

    @Override
    public void resolve(Object objectparam) {
        System.out.println("C类型解析文件；参数是："+objectparam);
    }
}
