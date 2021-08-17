package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


//589-N 叉树的前序遍历
public class P589_NAryTreePreorderTraversal {

    public static void main(String[] args) {

        Solution solution = new P589_NAryTreePreorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {


        List<Integer> results = new ArrayList<>();


        private void preOrder(Node root, List<Integer> results) {
            if (root == null) {
                return;
            }

            results.add(root.val);
            //叶子节点
            if (root.children == null) {
                return;
            }
            for (Node node : root.children) {
                preOrder(node, results);
            }

        }


        public List<Integer> preorder(Node root) {
            //第二周1:使用递归,前序遍历
            //        return useRecursion(root);
            //第二周2:使用双向链表
            return useStack(root);
        }


        //使用递归,最简单的方法
        private List<Integer> useRecursion(Node root) {
            List<Integer> results = new ArrayList<>();
            preOrder(root, results);
            return results;
        }


        //第二周2:使用双向链表
        private List<Integer> useStack(Node root) {
            if (root == null) {
                return Collections.emptyList();
            }
            LinkedList<Integer> results = new LinkedList<>();

            LinkedList<Node> deStack = new LinkedList<>();
            deStack.add(root);
            while (!deStack.isEmpty()) {
                Node cur = deStack.poll();
                //前序放在第一个
                results.addLast(cur.val);
                //最下层叶子节点
                if (cur.children == null) {
                    continue;
                }
                //先入后出,栈底
                for (int i = cur.children.size() - 1; i >= 0; i--) {
                    deStack.offerFirst(cur.children.get(i));
                }
            }
            return results;
        }
    }


    //leetcode submit region end(Prohibit modification and deletion)
    class Node {

        public int val;

        public List<Node> children;


        public Node() {
        }


        public Node(int _val) {
            val = _val;
        }


        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    ;
}