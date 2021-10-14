package leetcode.editor.cn;

//23-合并K个升序链表
public class P23_MergeKSortedLists {

    public static void main(String[] args) {

        P23_MergeKSortedLists merger = new P23_MergeKSortedLists();
        Solution solution = merger.new Solution();
        ListNode l1 = merger.new ListNode(1);
        l1.next = merger.new ListNode(4);
        l1.next.next = merger.new ListNode(5);

        ListNode l2 = merger.new ListNode(1);
        l2.next = merger.new ListNode(3);
        l2.next.next = merger.new ListNode(4);

        ListNode l3 = merger.new ListNode(2);
        l3.next = merger.new ListNode(6);
        ListNode[] array = {l1, l2, l3};
        System.out.println(solution.mergeKLists(array));
    }
    //leetcode submit region begin(Prohibit modification and deletion)


    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
     * this.next = next; } }
     */
    class Solution {

        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            ListNode mergeNode = new ListNode();
            ListNode current = mergeNode;
            while (true) {
                ListNode minNode = null;
                int firstIndex = 0;
                int lastIndex = -1;
                for (int i = 0; i < lists.length; i++) {
                    if (lists[i] == null) {
                        continue;
                    }
                    //第一次赋值
                    ListNode listNode = lists[i];
                    if (minNode == null) {
                        minNode = listNode;
                        firstIndex = i;
                        continue;
                    }
                    if (minNode != null) {
                        //如果小于当前则使用,然后往后移动一位
                        if (minNode.val > listNode.val) {
                            minNode = listNode;
                            lastIndex = i;
                        }
                    }
                }
                //遍历结束,还没找到
                if (minNode == null) {
                    break;
                }
                //第一个是最小的时候就往后移动一位即可;
                if (minNode.equals(lists[firstIndex])) {
                    lists[firstIndex] = lists[firstIndex].next;
                }
                //找到最小的时候才移动位置
                if (lastIndex > 0) {
                    lists[lastIndex] = lists[lastIndex].next;
                }

                //找到了,赋值后再置空;
                current.next = minNode;
                current = minNode;
            }
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