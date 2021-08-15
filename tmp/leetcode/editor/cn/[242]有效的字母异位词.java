//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "rat", t = "car"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, t.length <= 5 * 104 
// s 和 t 仅包含小写字母 
// 
//
// 
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 哈希表 字符串 排序 
// 👍 412 👎 0


import java.util.HashMap;


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     *
     */
    public boolean isAnagram(String s, String t) {
        return useMapCnt(s, t);
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


    /**
     * <b>方法一 :</b>使用字典统计
     * <p>时间复杂度:O(n)+O(n)+O(n)=O(n)</p>
     */
    private boolean useMapCnt(String s, String t) {
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
}
//leetcode submit region end(Prohibit modification and deletion)
