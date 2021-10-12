package com.ntencent;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author cm
 * @create 2021/9/15-10:28 下午
 *
 * 描述
 * 给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 */
public class GetLeastNumbers {

    /**
     * 将数组进行排序，然后取出来放在里面
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        quickSort(input,0,input.length -1);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        System.out.println(Arrays.toString(input));
        return list;
    }
    /**
     * 快速排序
     */
    public static void quickSort(int[] arr, int leftBound, int rightBound){
        if (leftBound >= rightBound) return;
        int mid = partition(arr, leftBound, rightBound);
        quickSort(arr,leftBound,mid-1);
        quickSort(arr,mid+1,rightBound);
    }

    static int partition(int[] arr, int leftBound, int rightBound) {
        int pivot = arr[rightBound];//以最右边那个数作为基数
        int left = leftBound;
        int right = rightBound - 1;
        while (left <= right){
            while (left <= right && arr[left] <= pivot) left++;
            while (left <= right && arr[right] >= pivot) right--;
            if (left < right){
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
        int tmp = arr[left];
        arr[left] = arr[rightBound];
        arr[rightBound] = tmp;
        return left;
    }
//    public void quickSort(int[] arr,int leftBound, int rightBound){
//        if (leftBound >= rightBound) return;
//        int mid = partition(arr,leftBound,rightBound);
//        quickSort(arr,leftBound,mid-1);
//        quickSort(arr,mid+1,rightBound);
//    }
//    public int partition(int[] arr,int leftBound, int rightBound){
//        int pivot = arr[rightBound];//以最右边那个数作为基数
//        int left = leftBound;
//        int right = rightBound - 1;
//        while (left <= right){
//            while (left <= right && arr[left] <= pivot) left++;
//            while (left <= right && arr[right] >= pivot) right--;
//            while (left <= right && pivot >= arr[right]) right--;
//            while (left <= right && pivot <= arr[left]) left++;
//            if (left < right){
//                int tmp = arr[left];
//                arr[left] = arr[right];
//                arr[right] = tmp;
//            }
//        }
//        int tmp = arr[left];
//        arr[left] = arr[rightBound];
//        arr[rightBound] = tmp;
//        return left;
//    }

    public static void main(String[] args) {
        int[] input = {4,5,1,6,2,7,3,8};
        GetLeastNumbers am = new GetLeastNumbers();
        ArrayList<Integer> list = am.GetLeastNumbers_Solution(input, 4);
        System.out.println(list);
    }
}
