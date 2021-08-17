package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;


//94-二叉树的中序遍历
public class P94_BinaryTreeInorderTraversal {

    public static void main(String[] args) {

        Solution solution = new P94_BinaryTreeInorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {

        public List<Integer> inorderTraversal(TreeNode root) {
            return useRecursion(root);
        }


        private void inorderTraversalRecursion(TreeNode root, List<Integer> results) {
            if (root == null) {
                return;
            }
            inorderTraversalRecursion(root.left, results);
            results.add(root.val);
            inorderTraversalRecursion(root.right, results);

        }


        //使用递归,最简单的方法
        private List<Integer> useRecursion(TreeNode root) {
            List<Integer> results = new ArrayList<>();
            inorderTraversalRecursion(root, results);
            return results;
        }
    }


    //leetcode submit region end(Prohibit modification and deletion)
    class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;


        TreeNode() {
        }


        TreeNode(int val) {
            this.val = val;
        }


        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}