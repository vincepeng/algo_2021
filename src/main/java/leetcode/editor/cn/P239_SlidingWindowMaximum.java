package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;


//239-滑动窗口最大值
public class P239_SlidingWindowMaximum {

    public static void main(String[] args) {
        Solution solution = new P239_SlidingWindowMaximum().new Solution();

        //
        int[] a1 = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(solution.maxSlidingWindow(a1, 3)));
        int[] a2 = {1};
        System.out.println(Arrays.toString(solution.maxSlidingWindow(a2, 1)));
        int[] a3 = {1, -1};
        System.out.println(Arrays.toString(solution.maxSlidingWindow(a3, 1)));
        int[] a4 = {9, 11};
        System.out.println(Arrays.toString(solution.maxSlidingWindow(a4, 2)));
        int[] a5 = {4, -2};
        System.out.println(Arrays.toString(solution.maxSlidingWindow(a5, 2)));
        int[] a6 = {-7, -8, 7, 5, 7, 1, 6, 0};
        System.out.println(Arrays.toString(solution.maxSlidingWindow(a6, 4)));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] maxSlidingWindow(int[] nums, int k) {
            //            return useForce(nums, k);
            //            return useObj(nums, k);
            return useQueue(nums, k);

        }


        //		暴力法:(n*n)
        //1.维持一个窗口的里面的数组,每次对这个数组找最大值(n)
        //2.然后返回这个最大值就行...
        private int[] useForce(int[] nums, int k) {
            List<Integer> sourceNums = Arrays.stream(nums).boxed().collect(Collectors.toList());
            int[] r2 = new int[nums.length - k + 1];
            LinkedList<Integer> windows = new LinkedList<>(sourceNums.subList(0, k));
            r2[0] = windowMax(windows);
            for (int i = k; i < nums.length; i++) {
                windows.removeFirst();
                windows.addLast(nums[i]);

                r2[i - k + 1] = windowMax(windows);
            }

            return r2;
        }


        private int[] useObj(int[] nums, int k) {
            SortedSet<Obj> objects = new TreeSet<>();
            int[] result = new int[nums.length - k + 1];
            Map<Integer, Obj> record = new HashMap<>();
            //n*(logn+logn)
            for (int i = 0; i < nums.length; i++) {
                Obj obj = new Obj(i, nums[i]);
                objects.add(obj);
                int windowIndex = i - k + 1;
                record.put(i, obj);
                if (windowIndex >= 0) {
                    result[windowIndex] = objects.first().value;
                    objects.remove(record.get(windowIndex));
                }

            }


            return result;
        }


        private int[] useQueue(int[] nums, int k) {
            Deque<Integer> deque = new ArrayDeque<>();
            int[] result = new int[nums.length - k + 1];
            for (int i = 0; i < nums.length; i++) {
                //队尾如果小于当前值则移除,确保都是大于当前的,队列按照大小顺序进行排列
                while (deque.size() > 0 && nums[deque.peekLast()] < nums[i]) {
                    deque.pollLast();
                }

                deque.addLast(i);

                //如果首段的元素小于窗口左边的索引,也移除;
                int leftIndex = i - k;
                if (deque.peekFirst() <= leftIndex) {
                    deque.pollFirst();
                }
                //从k-1就可以开始放入结果队列中了
                if (i >= k - 1) {
                    result[i - k + 1] = nums[deque.peekFirst()];
                }

            }
            return result;
        }


        private int windowMax(List<Integer> windows) {
            int max = windows.get(0);
            Iterator<Integer> iterator = windows.iterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                max = Math.max(max, next);
            }
            return max;
        }

    }


    class Obj implements Comparable<Obj> {

        public Integer index;

        public Integer value;


        public Obj(Integer index, Integer value) {
            this.index = index;
            this.value = value;
        }


        @Override
        public int compareTo(Obj o) {
            if (!o.value.equals(this.value)) {
                return o.value.compareTo(this.value);
            }
            //忘记重复会被set移除;
            return o.index.compareTo(this.index);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}