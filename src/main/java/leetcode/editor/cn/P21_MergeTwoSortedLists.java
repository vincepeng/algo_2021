package leetcode.editor.cn;

//21-合并两个有序链表
public class P21_MergeTwoSortedLists {

    public static void main(String[] args) {

        Solution solution = new P21_MergeTwoSortedLists().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)


    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
     * this.next = next; } }
     */
    class Solution {

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            //开头的(放一个虚拟节点)
            ListNode mergeNode = new ListNode();
            ListNode current = mergeNode;
            //合并
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    current.next = l1;
                    l1 = l1.next;
                }else {
                    current.next = l2;
                    l2 = l2.next;
                }
                current = current.next;
            }
            //2.追加剩余的
            if (l1 == null && l2 != null) {
                current.next = l2;
            }else if (l2 == null && l1 != null) {
                current.next = l1;
            }
            //3.第一个是虚拟的节点,直接丢弃掉
            return mergeNode.next;

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