/***
 * 统计一个数字在排序数组中出现的次数
 */
public class GetNumberOfK {
    //使用二分查找思想，先找出中间数字 mid，如果要查找的数字 k 小于 mid ，则对 mid 左边的数进行二分查找，
    //如果大于 mid，则对 mid 右边的数进行二分查找。分别找出第一个 k 和 最后一个 k 的下标，最后计算出 k 的个数
    public int getNumberOfK(int [] array , int k) {
        if(array == null || array.length == 0){
            return 0;
        }
		int count = 0;
        int first = getFirstK(array, k);
        int last = getLastK(array, k);
        if(first > -1 && last > -1){
            count = last - first + 1;
        }
        return count;
    }
    public int getFirstK(int[] array, int k){
        int start = 0;
        int end = array.length - 1;
        int mid = 0;
        while(start <= end){
            mid = (start + end) / 2;
            if(array[mid] < k){
                start = mid + 1;
            }else if(array[mid] > k){
                end = mid - 1;
            }else{
                if(mid > 0 && array[mid - 1] != k || mid == 0){
                    return mid;
                }else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
    public int getLastK(int[] array, int k){
        int start = 0;
        int end = array.length - 1;
        int mid = 0;
        while(start <= end){
            mid = (start + end) / 2;
            if(array[mid] < k){
                start = mid + 1;
            }else if(array[mid] > k){
                end = mid - 1;
            }else{
                if(mid < array.length - 1 && array[mid + 1] != k || mid == array.length - 1){
                    return mid;
                }else{
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

}