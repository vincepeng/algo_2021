package leetcode.editor.cn;

//83-删除排序链表中的重复元素
public class P83_RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {

        Solution solution = new P83_RemoveDuplicatesFromSortedList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)


    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
     * this.next = next; } }
     */
    class Solution {

        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode prev = head;
            ListNode node = prev.next;
            while (node != null) {
                //有重复
                if (prev.val == node.val) {
                    prev.next = node.next;
                    node = node.next;
                }else {
                    prev = node;
                }
            }
            return head;
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