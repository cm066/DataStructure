package com.example.demo.strategy;

/**
 * @author cm
 * @create 2021/10/30-11:59 上午
 */
public interface IFileStrategy {
    //属于哪种文件解析类型
    FileTypeResolveEnum gainFileType();

    //封装的公用算法（具体的解析方法）
    void resolve(Object objectparam);
}
