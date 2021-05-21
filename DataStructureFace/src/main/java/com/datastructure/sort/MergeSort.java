package com.datastructure.sort;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {9,2,5,7,1,3};
//        mergeSort(arr);
        int[] nums = {1,4,7,8,3,6,9};
        //先写合并数组
        sort(nums,0,nums.length-1 );
        Swap.printArr(nums);
    }

    public static void sort(int[] arr,int left,int right){
        if (left == right) return;
        //分成两半，派左边和右边
        int mid = left + (right - left)/2;
        sort(arr,left,mid-1);
        sort(arr,mid+1,right);
        merge(arr,left,mid+1, right);

    }
    //是把两个部分有序的数组合并
    public static void merge(int[] arr,int leftPtr,int rightPtr,int rightBound){
        int mid = rightPtr - 1;
        int[] temp = new int[rightBound - leftPtr +1];
        int i = leftPtr;
        int j = rightPtr;
        int k = 0;//临时数组的指针
        while (i <= mid && j <= rightBound){
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid){
            temp[k++] = arr[i++];
        }
        while (j <= rightBound){
            temp[k++] = arr[j++];
        }
        for (int m = 0; m < temp.length; m++) {
            arr[leftPtr + m] = temp[m];
        }
    }






//    public static void mergeSort(int[] arr){
//        int[] temp = new int[arr.length];
//        sort(arr,0, arr.length -1,temp);
//    }
//
//    //这里进行分
//    public static void sort(int[] arr,int left,int right,int []temp){
//        //先分
//        if(left<right){
//            int mid = (left+right)/2;
//            sort(arr,left,mid,temp);//左边归并排序，使得左子序列有序
//            sort(arr,mid+1,right,temp);//右边归并排序，使得右子序列有序
//            merge(arr,left,mid,right,temp);//将两个有序子数组合并操作
//        }
//    }
//
//    //这里进行合
//    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
//        int i = left;//左序列指针
//        int j = mid+1;//右序列指针
//        int t = 0;//临时数组指针
//        while (i<=mid && j<=right){
//            if(arr[i]<=arr[j]){
//                temp[t++] = arr[i++];
//            }else {
//                temp[t++] = arr[j++];
//            }
//        }
//        while(i<=mid){//将左边剩余元素填充进temp中
//            temp[t++] = arr[i++];
//        }
//        while(j<=right){//将右序列剩余元素填充进temp中
//            temp[t++] = arr[j++];
//        }
//        t = 0;
//        //将temp中的元素全部拷贝到原数组中
//        while(left <= right){
//            arr[left++] = temp[t++];
//        }
//    }
}
