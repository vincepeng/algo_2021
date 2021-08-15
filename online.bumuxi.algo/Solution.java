//
// 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。 
//
// 
//
// 说明: 
//
// 为什么返回数值是整数，但输出的答案是数组呢? 
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// 
//// nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：2, nums = [1,2]
//解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,1,1,1,2,2,3,3,4]
//输出：5, nums = [0,1,2,3,4]
//解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3 * 104 
// -104 <= nums[i] <= 104 
// nums 已按升序排列 
// 
//
// 
// Related Topics 数组 双指针 
// 👍 2146 👎 0


import java.util.HashMap;


//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {

    public static void main(String[] args) {
        //        int[] a = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        String a = "fasddf";
        String b = "addsff";
        System.out.println(new Solution().isAnagram(a, b));
    }


    /**
     * 时间复杂度:O(n)+O(n)+O(n)=O(n)
     */
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }


        HashMap<Character, Integer> sourceCntMap = toCharMap(s);
        HashMap<Character, Integer> targetMap = toCharMap(t);
        if (sourceCntMap.keySet().size() != targetMap.keySet().size()) {
            return false;
        }
        for (Character c : sourceCntMap.keySet()) {
            Integer sourceCnt = sourceCntMap.get(c);
            Integer targetCnt = targetMap.get(c);
            if (targetCnt == null || !sourceCnt.equals(targetCnt)) {
                return false;
            }
        }
        return true;
    }


    /***
     * 将S转换为字符Map
     * @param s
     * @return
     */
    private HashMap<Character, Integer> toCharMap(String s) {
        char[] sourceChars = s.toCharArray();
        HashMap<Character, Integer> sourceCntMap = new HashMap<>();
        for (int i = 0; i < sourceChars.length; i++) {
            Integer cnt = sourceCntMap.get(sourceChars[i]);
            if (cnt == null) {
                sourceCntMap.put(sourceChars[i], 0);
            }else {
                sourceCntMap.put(sourceChars[i], ++cnt);
            }
        }
        return sourceCntMap;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
