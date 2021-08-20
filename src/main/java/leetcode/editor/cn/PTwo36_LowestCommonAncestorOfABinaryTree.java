package leetcode.editor.cn;

//236-Lowest Common Ancestor of a Binary Tree
public class PTwo36_LowestCommonAncestorOfABinaryTree {

    public static void main(String[] args) {

        Solution solution = new PTwo36_LowestCommonAncestorOfABinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)


    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int x) { val = x; } }
     */
    class Solution {

        /**
         * 这个理解有点复杂,所以不推荐,还是建议走深度优先算法,记录访问路径的;
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            //没有p,q直接返回null就可以了
            if (root == null) {
                return null;
            }
            //当前root就是p或者q,直接返回当前root就行了
            // (这里面说明q不在p下面,如果在则也算是找到了p满足题目要求)
            if (root == p || root == q) {
                return root;
            }
            //遍历
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            // 都为空,则为叶子节点
            if (left == null && right == null) {
                return null;
            }
            // 左边为空,则返回右边(右边可能为空,有空能有p或者q的以一个,也可能找到了),因此这里直接返回即可;
            if (left == null) {
                return right;
            }
            //同上
            if (right == null) {
                return left;
            }
            //只剩下最后一种,就是二者都不为空,则当前root就是最近节点了
            return root;
        }

    }


    //leetcode submit region end(Prohibit modification and deletion)
    public class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;


        TreeNode(int x) {
            val = x;
        }
    }
}