package leetcode.editor.cn;

//24-两两交换链表中的节点
public class P24_SwapNodesInPairs {

    public static void main(String[] args) {

        Solution solution = new P24_SwapNodesInPairs().new Solution();
    }
    /***
     *暴力法:abcd
     *a,b,c,d
     *使用一个队列的方式进行;
     */


    //leetcode submit region begin(Prohibit modification and deletion)


    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
     * this.next = next; } }
     */
    class Solution {

        public ListNode swapPairs(ListNode head) {
            //            return useRecruit(head);
            return useWhile(head);
        }


        private ListNode useRecruit(ListNode head) {
            //仅有一个(head,next,next.next)
            if (head == null || head.next == null) {
                return head;
            }
            ListNode next = head.next;
            head.next = swapPairs(next.next);
            next.next = head;
            return next;
        }


        private ListNode useWhile(ListNode head) {
            ListNode dummyHead = new ListNode();
            dummyHead.next = head;
            ListNode temp = dummyHead;

            while (temp.next != null && temp.next.next != null) {
                ListNode node1 = temp.next;
                ListNode node2 = temp.next.next;
                temp.next = node2;
                node1.next = node2.next;
                node2.next = node1;
                temp = node1;
            }
            return dummyHead.next;
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