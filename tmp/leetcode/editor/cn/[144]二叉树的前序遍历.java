//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 
// 👍 626 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;


/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode
 * right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        return useRecursion(root);
    }

    private void preorderTraversalRecursion(TreeNode root, List<Integer> results) {
        if (root == null) {
            return;
        }
        results.add(root.val);
        preorderTraversalRecursion(root.left, results);
        preorderTraversalRecursion(root.right, results);

    }


    //使用递归,最简单的方法
    private List<Integer> useRecursion(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        preorderTraversalRecursion(root, results);
        return results;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
