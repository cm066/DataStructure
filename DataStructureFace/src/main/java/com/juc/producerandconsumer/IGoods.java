package com.juc.producerandconsumer;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cm
 * @create 2021/10/26-11:43 下午
 */
public class IGoods {

    private String name;
    private Integer price;
    private static AtomicInteger no = new AtomicInteger(1);

    public IGoods() {
    }

    public IGoods(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public static IGoods produceOne(){
        return new IGoods(no.getAndIncrement()+"号",new Random(10).nextInt());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "IGoods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
