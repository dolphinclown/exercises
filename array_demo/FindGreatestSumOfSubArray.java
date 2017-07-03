/**
 * 连续字数组最大和 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)
 **/
public class FindGreatestSumOfSubArray {
    public int findGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length <= 0){
            return 0;
        }
        
        int maxSum = array[0];
        int curSum = maxSum;
        for(int i = 1; i < array.length; i++){
			if(curSum <= 0){
                curSum = array[i];
            }else{
                curSum += array[i];
            }
            
            if(maxSum < curSum){
                maxSum = curSum;
            }
        }
        
        return maxSum;
    }
}