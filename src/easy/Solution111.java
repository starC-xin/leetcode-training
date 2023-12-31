package easy;

import struct.TreeNode;

/**
 * 2021/10/20
 *
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 *
 * 示例 2：
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 *  
 *
 * 提示：
 *
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author x.c
 */
public class Solution111 {
    public int minDepth(TreeNode root) {
        if(null == root){
            return 0;
        }
        return def(root, 1, Integer.MAX_VALUE);
    }

    /**
     * 深度遍历
     * 存储最小叶子节点层数，逐渐更新最小层数，过滤掉大于次层数的节点
     */
    private int def(TreeNode node, int depth, int min){
        if(null == node){
            return min;
        }
        if(null == node.left && null == node.right){
            return Math.min(depth, min);
        }

        if(depth + 1 < min){
            min = Math.min(def(node.left, depth + 1, min), min);
            min = Math.min(def(node.right, depth + 1, min), min);
        }
        return min;
    }
}
