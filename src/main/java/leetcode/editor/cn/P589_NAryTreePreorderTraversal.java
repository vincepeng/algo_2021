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
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/


    class Solution {

        public List<Integer> preorder(Node root) {
            if (root == null) {
                return Collections.emptyList();
            }
            List<Integer> result = new ArrayList<>();
            LinkedList<Node> nodes = new LinkedList<>();
            nodes.addLast(root);
            while (nodes.size() > 0) {
                //先入后出
                Node node = nodes.pollLast();
                result.add(node.val);
                List<Node> children = node.children;
                if (children == null || children.isEmpty()) {
                    continue;
                }
                //右边的后遍历,因此先放入,左边的先遍历,因此最后放入,配合pollLast
                for (int i = children.size() - 1; i >= 0; i--) {
                    nodes.addLast(children.get(i));
                }

            }
            return result;
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
}