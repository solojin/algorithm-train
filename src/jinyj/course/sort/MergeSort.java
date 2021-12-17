package jinyj.course.sort;

import jinyj.util.DataStore;

// 归并排序
public class MergeSort {

    public static void main(String[] args) {
        Integer[] arr = DataStore.getData();
        String source = "";
        for(int i = 0; i < arr.length; i++) {
            source += arr[i] + " ";
        }
        System.out.println("原数组：" + source);
        MergeSort.sort(arr, 0, arr.length - 1);
        String res = "";
        for(int i = 0; i < arr.length; i++) {
            res += arr[i] + " ";
        }
        System.out.println("排序后：" + res);
    }

    // 归并排序
    public static void sort(Integer[] arr, int L, int R) {
        MergeSort.sort(arr, L, R);
    }

    // 二分后合并
    public static void process(Integer[] arr, int L, int R) {
        if(L == R) {
            return;
        }
        // 等价于L +（R - L）/ 2
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    // 合并
    public static void merge(Integer[] arr, int L, int M, int R) {
        // 辅助数组，用于存放R - L区间排序后的值
        Integer[] help = new Integer[R - L + 1];
        // 辅助数组当前位置
        int i = 0;
        // 左区间当前位置
        int p1 = L;
        // 右区间当前位置
        int p2 = M+1;
        // arr[p1]和arr[p2]对比大小，小值放入辅助数组，并自身索引加1
        while(p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 补充，考虑p2已放完，p1未放完的情况
        while(p1 <= M) {
            help[i++] = arr[p1++];
        }
        // 补充，考虑p1已放完，p2未放完的情况
        while(p2 <= R) {
            help[i++] = arr[p2++];
        }
        for(i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }
}
