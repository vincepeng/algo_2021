package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;


//144-二叉树的前序遍历
public class P144_BinaryTreePreorderTraversal {

    public static void main(String[] args) {

        Solution solution = new P144_BinaryTreePreorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)


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