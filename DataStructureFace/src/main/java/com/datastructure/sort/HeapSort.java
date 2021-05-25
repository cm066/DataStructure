package com.datastructure.sort;


/**
 * 堆排序，要理解完全二叉树，数组和完全二叉树可以相互转换
 * 转换关系极为2*i+1是当前节点的左孩子 2*i+2是当前节点的右孩子 当前节点的父节点为(i-1)/2
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {2,1,3,6,0,4};
        headSort(arr);
        Swap.printArr(arr);
    }
    public static void headSort(int[] arr){
        if (null == arr || arr.length < 2){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            insertHeap(arr,i);
        }
        int heapSize = arr.length;
        Swap.swap(arr,0,--heapSize);
        while (heapSize > 0){
            heapify(arr,0,heapSize);
            Swap.swap(arr,0,--heapSize);
        }
    }

    /**
     * 插入进堆里面，如果是降序排序就采用大根堆，大根堆即为当前节点堆的左右孩子都小于当前节点
     * 建立大根堆
     * @param arr
     * @param index
     */
    public static void insertHeap(int[] arr,int index){
        while (arr[index] > arr[(index-1)/2]){
            Swap.swap(arr,index,(index-1)/2);
            index = (index-1)/2;
        }
    }

    /**
     * 对大根堆进行排序
     * @param arr
     * @param index
     * @param heapSize
     */
    public static void heapify(int[] arr,int index,int heapSize){
        //得到当前节点的左孩子
        int left = 2*index +1;
        while (left < heapSize){
            int larget = left + 1 <heapSize && arr[left+1] > arr[left] ? left+1 : left;
            larget = arr[larget] > arr[index] ? larget : index;

            if (larget == index){
                break;
            }
            Swap.swap(arr,larget,index);//交互位置
            index = larget;
            left = index*2 + 1;
        }
    }
}
