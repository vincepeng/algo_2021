import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


//leetcode submit region begin(Prohibit modification and deletion)
public class SolutionTest {


    //由于这里是单线程,所以不用处理并发


    public static void main(String[] args) {
        //        Integer[] root = new Integer[]{1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10, null, null, 11, null, 12, null, 13, null, null, 14};
        //        List<Integer> ints1 = new Solution().preorder(root);
        //        System.out.printf(ints1.toString());
    }


    public List<Integer> preorder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        LinkedList<Integer> results = new LinkedList<>();

        LinkedList<Node> deStack = new LinkedList<>();
        deStack.add(root);
        while (!deStack.isEmpty()) {
            Node cur = deStack.poll();
            //前序放在第一个
            results.add(cur.val);
            //最下层叶子节点
            if (cur.children == null) {
                continue;
            }
            //先入后出,栈底
            for (int i = cur.children.size() - 1; i >= 0; i--) {
                deStack.add(cur.children.get(i));
            }
        }
        return results;
    }


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
//leetcode submit region end(Prohibit modification and deletion)
