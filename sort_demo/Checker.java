import java.util.*;
/**
  *请设计一个高效算法，判断数组中是否有重复值。必须保证额外空间复杂度为 O(1)。给定一个 int 数组 A 及它的大小 n，请返回它是否有重复值。
  */
public class Checker {
    public boolean checkDuplicate(int[] a, int n) {
        // 思路：使用堆排序，在删除大根或者小根的同时，和上一次删除的元素进行比对，如果相等，
        //      则存相等的元素，则说明重复。
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("参数错误");
        }
        boolean flag = false;
        for (int i = n / 2; i >= 0; i--) {
            buildHeap(a, i, n);
        }
        int lastOne;
        for (int i = n - 1; i > 0; i--) {
            swap(a, 0, i);
            lastOne = a[i];
            buildHeap(a, 0, i);
            if (lastOne == a[0]) {
                flag = true;
                break;
            }
        }
        return flag;
    }
    
    public void buildHeap(int[] a, int index, int length){
        int child;
        int temp = a[index];
        for( ; index * 2 + 1 < length; index = child){
            child = index * 2 + 1;
            if(child != length - 1 && a[child] < a[child + 1]){
                 child++;
            }
            if(temp > a[child]){
                break;
            } else {
                a[index] = a[child];
                index = child;
            }
        }
         a[index] = temp;
    }
     
    public void swap(int[] a,int m,int n){
        int temp = a[m];
        a[m] = a[n];
        a[n] = temp;
    }
}