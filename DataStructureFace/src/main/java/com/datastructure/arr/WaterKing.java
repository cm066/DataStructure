package com.datastructure.arr;


import java.util.HashMap;
import java.util.Map;

/**
 * 这是一道关于水王数的解法，什么是水王数？水王数即是一个数组中若这个数超过一个半，这个数即为水王数
 * {1，2，3，4，4，4} 4就是一个水王数
 * {1，2，3，4，4} 这个4就不是水王数， 因为没有超过一半
 * 要求时间复杂发为O(n） 空间复杂度为O（1）
 */
public class WaterKing {
    public static void main(String[] args) {

        int[] arr =  {1,2,3,4,4,4};
        int i = waterKing1(arr);
        System.out.println(i);

    }
    // TODO: 2021/5/7 解法一

    /**
     * 采用一个hash表来统计数据中每个数出现的次数，然后看是否有大于等于一半的
     * 但是不满足条件 时间复杂发为O(n） 空间复杂度为O（1） ，这样的解法空间复杂度为O（n）
     * @param arr
     * @return
     */
    public static int waterKing1(int[] arr){
        if (null == arr || arr.length == 0){
            return -1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else {
                map.put(arr[i],1);
            }
        }
        int N = arr.length;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= (N >> 1)){
                return entry.getKey();
            }
        }
        return -1;
    }

    // TODO: 2021/5/7  解法二
    /**
     * 解题思路
     *  1、先用两个变量，hp变量表示血量（即为出现几次） candidate 表示候选人即为已经出现过两次以上的
     *  2、遍历数组 ，因为第一个数，还没有血量和候选数，即把第一个数作为侯选数，然后hp加1
     *  3、然后从第二个数开始，如和候选数相同 即hp加1 反之就把两个数移除
     *  4、代码实现如下
     * @param arr
     * @return
     */
    public static int waterKing2(int[] arr){

        if (null == arr || arr.length == 0){
            return -1;
        }
        int hp = 0;//表示血量
        int candidate = 0;//表示候选数
        for (int i = 0; i < arr.length; i++) {
           if (hp == 0){
               candidate = arr[i];
               hp = 1;
           }else {
               if (candidate != arr[i]){
                   hp--;
               }else {
                   hp++;
               }
           }
        }
        //这里表示遍历到最后若血量为0，即没有留下来数，即为没有水王数
        if (hp == 0){
            return -1;
        }
        //到这里说明还有候选数，在遍历一次数组，然后候选数出现的次数是否超过一半
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (candidate == arr[i]){
                count ++;
            }
        }
        int N = arr.length;
        return  count >= (N >> 1) ? candidate : -1;
    }
}
