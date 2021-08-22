package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;


//105-从前序与中序遍历序列构造二叉树
public class P105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {

        Solution solution = new P105_ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        int[] inOrder = {9, 3, 15, 20, 7};
        int[] preOrder = {3, 9, 20, 15, 7};
        TreeNode treeNode = solution.buildTree(preOrder, inOrder);
        System.out.println(treeNode.val);
    }
    //leetcode submit region begin(Prohibit modification and deletion)


    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode
     * right) { this.val = val; this.left = left; this.right = right; } }
     */
    class Solution {

        private TreeNode backup(int[] preorder, int[] inorder) {
            Map<Integer, Integer> inMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inMap.put(inorder[i], i);
            }
            int preRootIndex = 0;
            TreeNode root = new TreeNode();
            getTree(preorder, inorder, root, inMap, preRootIndex);
            return root;
        }


        public TreeNode buildTree(int[] preorder, int[] inorder) {
            Map<Integer, Integer> inMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inMap.put(inorder[i], i);
            }

            return doGetTree(preorder, inorder, 0, preorder.length, 0, inorder.length, inMap);

        }


        private TreeNode doGetTree(int[] preorder, int[] inorder, int pStart, int pEnd, int iStart, int iEnd, Map<Integer, Integer> inMap) {
            if (pStart == pEnd) {
                return null;
            }
            int root = preorder[pStart];
            Integer inRootIndex = inMap.get(root);
            //前序 :根->左->右
            //中序:左->根->右
            int leftNum = inRootIndex - iStart;
            TreeNode treeNode = new TreeNode(root);
            treeNode.left = doGetTree(preorder, inorder, pStart + 1, pStart + leftNum + 1, iStart, inRootIndex, inMap);
            treeNode.right = doGetTree(preorder, inorder, pStart + leftNum + 1, pEnd, inRootIndex + 1, iEnd, inMap);

            return treeNode;

        }


        /**
         * 需要在想想,有边界条件
         */
        private int getTree(int[] preorder, int[] inorder, TreeNode node, Map<Integer, Integer> inMap, int preRootIndex) {
            //终止条件
            if (preRootIndex == inorder.length - 1) {
                node.val = preorder[preRootIndex];
                return 0;
            }
            //前序遍历的第一个
            int offset = 0;
            if (preRootIndex < preorder.length - 2) {
                //前序 :根->左->右
                //中序:左->根->右
                //要不是是左,要不是右,要不是下一个根.由于二叉树里面数字都不等
                Integer inRootIndex = inMap.get(preorder[preRootIndex]);
                //左    避免没有左子树


                if ((inorder[inRootIndex - 1] == preorder[preRootIndex + 1])) {
                    node.left = new TreeNode(preorder[preRootIndex + 1]);
                    offset++;
                    int nextIndex = preRootIndex + offset + 1;
                    if (nextIndex < preorder.length - 1) {
                        //右边也相等
                        if (inorder[inRootIndex + 1] == preorder[nextIndex]) {
                            node.right = new TreeNode(preorder[nextIndex]);
                            offset++;
                            //                            getTree(preorder, inorder, node.right, inMap, preRootIndex);
                        }
                    }
                    offset += getTree(preorder, inorder, node.left, inMap, preRootIndex + offset);
                    if (node.right != null) {
                        offset += getTree(preorder, inorder, node.right, inMap, preRootIndex + offset);
                    }

                    //右
                }else if (inorder[inRootIndex + 1] == preorder[preRootIndex + 1]) {
                    node.right = new TreeNode(preorder[preRootIndex + 1]);
                    offset++;
                    offset += getTree(preorder, inorder, node.right, inMap, preRootIndex + offset);
                    //只能是下一个根,直接进入下一个
                }

            }
            return offset;
        }
    }


    //leetcode submit region end(Prohibit modification and deletion)
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