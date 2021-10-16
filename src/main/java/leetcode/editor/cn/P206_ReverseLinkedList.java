package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;


//206-反转链表
public class P206_ReverseLinkedList {


    public static void main(String[] args) {

        P206_ReverseLinkedList list = new P206_ReverseLinkedList();
        Solution solution = list.new Solution();
        ListNode listNode = list.new ListNode(1);
        listNode.next = list.new ListNode(2);
        listNode.next.next = list.new ListNode(3);
        ListNode listNode1 = solution.reverseList(listNode);
        System.out.println(listNode1);

    }
    //leetcode submit region begin(Prohibit modification and deletion)


    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
     * this.next = next; } }
     */
    class Solution {

        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode listNode = subRecursion(head);
            //第一个进行置空,避免无限循环
            head.next = null;
            return listNode;
        }


        //1,2,3,4
        private ListNode subRecursion(ListNode node) {
            //证明没有下一个了,直接返回
            if (node.next == null) {
                return node;
            }
            ListNode next = node.next;
            ListNode listNode = subRecursion(next);
            next.next = node;
            return listNode;
        }


        private ListNode useStack(ListNode head) {
            if (head == null) {
                return head;
            }
            Deque<ListNode> stack = new LinkedList<>();
            ListNode current = head;
            while (current != null) {
                stack.push(current);
                current = current.next;
            }
            ListNode ret = stack.pop();
            current = ret;
            while (!stack.isEmpty()) {
                current.next = stack.pop();
                current = current.next;
            }
            //最后一个置空掉,因为没有下一个了;
            current.next = null;
            return ret;
        }
    }


    //leetcode submit region end(Prohibit modification and deletion)
    public class ListNode {

        int val;

        ListNode next;


        ListNode() {
        }


        ListNode(int val) {
            this.val = val;
        }


        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}