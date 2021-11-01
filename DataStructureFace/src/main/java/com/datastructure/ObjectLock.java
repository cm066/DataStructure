package com.datastructure;

import org.openjdk.jol.vm.VM;

/**
 * @author cm
 * @create 2021/10/28-12:31 上午
 */
public class ObjectLock {

    public void printInfo(){
        System.out.println(VM.current().details());
    }
}
