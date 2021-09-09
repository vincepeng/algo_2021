package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


//590-N 叉树的后序遍历
public class P590_NAryTreePostorderTraversal {

    public static void main(String[] args) {

        Solution solution = new P590_NAryTreePostorderTraversal().new Solution();
        P590_NAryTreePostorderTraversal p = new P590_NAryTreePostorderTraversal();
        Node root = p.new Node(1);
        Node n3 = p.new Node(3);
        Node n5 = p.new Node(5);
        Node n6 = p.new Node(6);
        n3.children = Arrays.asList(n5, n6);
        Node n2 = p.new Node(2);
        Node n4 = p.new Node(4);
        root.children = Arrays.asList(n3, n2, n4);
        System.out.println(solution.postorder(root));

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

        public List<Integer> postorder(Node root) {
            LinkedList<Integer> res = new LinkedList<>();
            if (root == null) {
                return res;
            }

            Deque<Node> stack = new ArrayDeque<>();
            stack.addLast(root);
            while (!stack.isEmpty()) {
                Node node = stack.removeLast();
                res.addFirst(node.val);
                for (int i = 0; i < node.children.size(); i++) {
                    stack.addLast(node.children.get(i));
                }
            }
            return res;
        }


        public List<Integer> postorder2(Node root) {
            if (root == null) {
                return Collections.emptyList();
            }
            LinkedList<Integer> result = new LinkedList<>();
            LinkedList<Node> nodes = new LinkedList<>();
            Set<Node> visited = new HashSet<>();
            nodes.addLast(root);
            while (nodes.size() > 0) {
                //先入先出;
                Node node = nodes.peekLast();
                List<Node> children = node.children;
                if (children == null || children.isEmpty()) {
                    result.add(node.val);
                    nodes.removeLast();
                }else {
                    //右边的先遍历,因此后放入,左边的后遍历,因此先放入,配合pollLast
                    //第二次访问了,可以直接加入到node里面去
                    if (visited.contains(node)) {
                        result.add(node.val);
                        nodes.removeLast();
                    }else {
                        visited.add(node);
                        //                        for (int i = 0; i < children.size(); i++) {
                        //                            nodes.addLast(children.get(i));
                        //                        }
                        for (int i = children.size() - 1; i >= 0; i--) {
                            nodes.addLast(children.get(i));
                        }
                    }
                }
            }
            return result;
        }
    }


    //leetcode submit region end(Prohibit modification and deletion)
    class Node {

        public int val;

        public List<Node> children = new ArrayList<>();


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