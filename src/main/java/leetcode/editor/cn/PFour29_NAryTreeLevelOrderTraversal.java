package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


//429-N-ary Tree Level Order Traversal
public class PFour29_NAryTreeLevelOrderTraversal {

    public static void main(String[] args) {

        Solution solution = new PFour29_NAryTreeLevelOrderTraversal().new Solution();
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

        private void getRes(List<Node> parents, List<List<Integer>> res) {
            if (parents == null || parents.isEmpty()) {
                return;
            }
            List<Integer> cur = new ArrayList<>();
            List<Node> nextLevelChildren = new ArrayList<>();
            parents.stream().filter(Objects::nonNull).forEach(node -> {
                cur.add(node.val);
                if (node.children != null && node.children.size() > 0) {
                    nextLevelChildren.addAll(node.children);
                }
            });
            res.add(cur);
            getRes(nextLevelChildren, res);
        }


        public List<List<Integer>> levelOrder(Node root) {
            if (root == null) {
                return Collections.emptyList();
            }
            List<List<Integer>> res = new ArrayList<>();
            List<Node> first = new ArrayList<>();
            first.add(root);
            getRes(first, res);

            return res;

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