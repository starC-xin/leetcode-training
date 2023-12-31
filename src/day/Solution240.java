package day;

/**
 * 2021/10/25
 *
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author x.c
 */
public class Solution240 {

    public static void main(String[] args){
        int[][] matrix = new int[][]{{1,4},{2,5}};
        System.out.println(new Solution240().searchMatrix(matrix, 2));
    }


    public boolean searchMatrix(int[][] matrix, int target) {
        int line = 0;
        int i = 0;
        while(line < matrix.length && i < matrix[line].length){
            int num = matrix[line][i];
            if(target == num){
                return true;
            }
            if(target < num){
                i = 0;
                line ++;
            }else{
                i ++;
            }

            if(line < matrix.length && i >= matrix[line].length){
                i = 0;
                line ++;
            }
        }
        return false;
    }
}
