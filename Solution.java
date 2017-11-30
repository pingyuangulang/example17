/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 吉彬
 */
public class Solution {
    public static void main(String[] args){
        int[] sequence = {1,2,3,4,5};
        boolean bool = new Solution().VerifySquenceOfBST(sequence);
        System.out.println("bool = "+bool);
    }
    /*
    问题：
    输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
    如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
    */
    
    /*
    解决思路：
    后序遍历序列中最后一个是根节点，
    遍历序列第一个比根节点大的元素之前的元素为此根的左子树，
    该节点及以后的除根节点的元素为此根的右子树。
    判断右子树中如果有比根节点小的节点则返回NO；
    否则接着以递归的思想判断左右子树是否满足条件。
    */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null || sequence.length==0)
            return false;
        return verifySquenceOfBST(sequence,0,sequence.length-1);
    }
    private boolean verifySquenceOfBST(int[] sequence,int start,int end){
        if(end<start)
            return false;
        if(end==start || end-start==1)
            return true;
        int root = sequence[end];
        int i = start;//右子树起始节点
        //由根节点区分左右子树
        for(;i<=end;++i){
            if(root<sequence[i])
                break;
        }
        //遍历右子树
        for(int j=i;j<end;j++){
            //如果右子树中有比根节点小的节点，则说明不是二叉搜索树后序遍历
            if(sequence[j]<root)
                return false;
        }
        boolean left = true;
        boolean right = true;
        //如果此条件成立，则说明root节点有左子树或右子树
        if(i>start && i<end){
            left = verifySquenceOfBST(sequence,start,i-1);
            right = verifySquenceOfBST(sequence,i,end-1);
        }
        
        return (left&&right);
    }
}
