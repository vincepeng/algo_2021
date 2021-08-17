package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;


//剑指 Offer 06-从尾到头打印链表
public class P剑指Offer06_CongWeiDaoTouDaYinLianBiaoLcof {

    public static void main(String[] args) {


        P剑指Offer06_CongWeiDaoTouDaYinLianBiaoLcof outter = new P剑指Offer06_CongWeiDaoTouDaYinLianBiaoLcof();
        Solution solution = outter.new Solution();

        ListNode fist = outter.new ListNode(0);
        ListNode head = fist;
        int i = 1;
        while (i < 10) {
            head.next = outter.new ListNode(i++);
            head = head.next;
        }
        System.out.println(Arrays.toString(solution.reversePrint(fist)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)


    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int x) { val = x; } }
     */
    class Solution {

        public int[] reversePrint(ListNode head) {
            return useStream(head);
        }


        private int[] useLinkList(ListNode head) {
            //暴力法,放入栈,在先入后出;(使用deque)
            //first->last
            Deque<Integer> que = new LinkedList();
            while (head != null) {
                que.addLast(head.val);
                head = head.next;
            }
            int[] results = new int[que.size()];
            for (int i = 0; i < results.length; i++) {
                results[i] = que.pollLast();
            }
            return results;
        }


        private int[] useStream(ListNode head) {

            //first->last(1,2,3,4)->4,3,2,1
            Deque<Integer> que = new LinkedList();
            while (head != null) {
                que.addFirst(head.val);
                head = head.next;
            }
            int[] res = que.stream().mapToInt(Integer::intValue).toArray();
            return res;
        }
    }


    //leetcode submit region end(Prohibit modification and deletion)
    class ListNode {

        int val;

        ListNode next;


        ListNode(int x) {
            val = x;
        }
    }
}