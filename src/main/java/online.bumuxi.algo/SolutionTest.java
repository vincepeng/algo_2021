package online.bumuxi.algo;

import java.util.ArrayList;
import java.util.List;


//leetcode submit region begin(Prohibit modification and deletion)
public class SolutionTest {


    //由于这里是单线程,所以不用处理并发


    public static void main(String[] args) {
        //        Integer[] root = new Integer[]{1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10, null, null, 11, null, 12, null, 13, null, null, 14};
        //        List<Integer> ints1 = new Solution().preorder(root);
        //        System.out.printf(ints1.toString());
    }


    public List<Integer> preorderTraversal(TreeNode root) {
        return useRecursion(root);
    }


    private void preorderTraversalRecursion(TreeNode root, List<Integer> results) {
        if (root == null) {
            return;
        }
        results.add(root.val);
        //叶子节点
        if (root.left != null) {
            preorderTraversalRecursion(root.left, results);
        }

        if (root.right != null) {
            preorderTraversalRecursion(root.left, results);
        }
    }


    //使用递归,最简单的方法
    private List<Integer> useRecursion(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        preorderTraversalRecursion(root, results);
        return results;
    }


    public class TreeNode {

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
//leetcode submit region end(Prohibit modification and deletion)
