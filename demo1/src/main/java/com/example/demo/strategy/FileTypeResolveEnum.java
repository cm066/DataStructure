package com.example.demo.strategy;

/**
 * @author cm
 * @create 2021/10/30-11:59 上午
 */
public enum FileTypeResolveEnum {
    File_A_RESOLVE("typeA"),
    File_B_RESOLVE("typeB"),
    File_C_RESOLVE("typeC"),
    File_DEFAULT_RESOLVE("deefalut");
    private String name;
    private FileTypeResolveEnum(String name){
        this.name = name;
    }
}
