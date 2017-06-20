/**输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 *如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {
    public boolean verifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length <= 0){
            return false;
        }
		return isBST(sequence, 0, sequence.length - 1);
    }
    
    public boolean isBST(int[] sequence, int start, int end){
        if(end <= start){
            return true;
        }
        //序列的最后一个元素为根
        int root = sequence[end];
        //遍历数组找到二叉树根的左子树部分
        int i = start;
        for(; i < end; i++){
            if(sequence[i] > root){
                break;
            }
        }
        
        int j = i;
        for(; j < end; j++){
            if(sequence[j] < root){
                return false;
            }
        }
        
        //递归的判断根的左子树，和右子树是否为二叉搜索树后序遍历序列
        return isBST(sequence, start, i - 1) && isBST(sequence, i, j - 1);
    }
}