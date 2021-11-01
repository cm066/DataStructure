package com.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author cm
 * @create 2021/10/24-7:45 下午
 */
public class ThreadLocalTest2 {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            SpeedLog.beginSpeedLog();
            try {
                serviceMt();
                SpeedLog.endSpeedLog();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }
    public static void serviceMt() throws InterruptedException {
        TimeUnit.SECONDS.sleep(10);
        SpeedLog.logPoint("point service1");
        A();
        B();
    }
    public static void A() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        SpeedLog.logPoint("point service2");
    }
    public static void B() throws InterruptedException {
        TimeUnit.SECONDS.sleep(12);
        SpeedLog.logPoint("point service3");
    }
}

class SpeedLog{
    private static final ThreadLocal<Map<String,Long>> THREAD_LOCAL  = ThreadLocal.withInitial(SpeedLog::initStartTime);
    public static Map<String,Long> initStartTime(){
        Map<String,Long> map = new HashMap<>();
        map.put("start",System.currentTimeMillis());
        map.put("last",System.currentTimeMillis());
        return map;
    }
    public static final void beginSpeedLog(){
        System.out.println("开始耗时记录:"+THREAD_LOCAL.get().get("start"));
        THREAD_LOCAL.get();
    }
    public static final void endSpeedLog(){
        THREAD_LOCAL.remove();
        System.out.println("结束耗时记录:"+THREAD_LOCAL.get().get("last"));
    }

    public static final void logPoint(String point){
        Long last = THREAD_LOCAL.get().get("last");
        Long cast = System.currentTimeMillis()-last;
        THREAD_LOCAL.get().put(point+"cost",cast);
        System.out.println(point+"花费多长时间："+THREAD_LOCAL.get().get(point+"cost"));
        THREAD_LOCAL.get().put("last",System.currentTimeMillis());
    }}