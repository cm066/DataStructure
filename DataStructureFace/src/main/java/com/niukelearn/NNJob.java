package com.niukelearn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author cm
 * @create 2021/10/24-10:58 上午
 * 为了找到自己满意的工作，牛牛收集了每种工作的难度和报酬。牛牛选工作的标准是在难度不超过自身能力值的情况下，
 * 牛牛选择报酬最高的工作。在牛牛选定了自己的工作后，牛牛的小伙伴们来找牛牛帮忙选工作，牛牛依然使用自己的标准来帮助小伙伴们。
 * 牛牛的小伙伴太多了，于是他只好把这个任务交给了你。
 */
public class NNJob {
    public static void main(String[] args) {
//（1 50 ）（1  200 ） （2 300）
        Job job = new Job(100, 1);
        Job job1 = new Job(1000, 10);
        Job job2 = new Job(1001, 1000000000);
        Job[] arr = {job,job1,job2};
        int[] res = {9,10,1000000000};
        int[] moneys = getMoneys(arr, res);
        System.out.println(Arrays.toString(moneys));

    }
    public static class Job {
        public int money;
        public int hard;

        public Job(int money, int hard) {
            this.money = money;
            this.hard = hard;
        }
    }

    public static class JobComparator implements Comparator<Job> {
        @Override
        public int compare(Job o1, Job o2) {
            return o1.hard != o2.hard ? (o1.hard - o2.hard) : (o2.money - o1.money);
        }
    }

    /**
     * 3 3
     * job[1 100
     *      * 10 1000
     *      * 1000000000 1001 ]
     * ability[9 10 1000000000]
     * @param job
     * @param ability
     * @return
     */
    public static int[] getMoneys(Job[] job, int[] ability) {
        Arrays.sort(job,new JobComparator());
        //然后根据工作所需的能量值和报酬进行排序，列入  （1 50 ）（1  200 ） （2 300） 排序后就是 （1  200 ）（1 50 ） （2 300）
        // 难度为key的工作，最优钱数是多少，有序表
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(job[0].hard, job[0].money);
        // pre 之前组的组长
        Job pre = job[0];
        for (int i = 1; i < job.length; i++) {
            if (job[i].hard != pre.hard && job[i].money > pre.money) {
                pre = job[i];
                map.put(pre.hard, pre.money);
            }
        }
    //        1=100
    //        10=1000
    //        1000000000=1001
    //        9 10 1000000000
        int[] ans = new int[ability.length];
        for (int i = 0; i < ability.length; i++) {
            Integer key = map.floorKey(ability[i]);
            ans[i] = key != null ? map.get(key) : 0;
        }
        return ans;

    }
}
