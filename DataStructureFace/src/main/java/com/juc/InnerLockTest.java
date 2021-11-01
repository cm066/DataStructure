package com.juc;

import com.datastructure.ObjectLock;
import org.openjdk.jol.vm.VM;

import java.util.concurrent.TimeUnit;

/**
 * @author cm
 * @create 2021/10/28-12:28 上午
 */
public class InnerLockTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(VM.current().details());
        TimeUnit.SECONDS.sleep(5);
        ObjectLock  lock = new ObjectLock();
        lock.printInfo();
    }
}
