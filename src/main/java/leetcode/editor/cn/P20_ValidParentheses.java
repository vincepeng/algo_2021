package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;


//20-有效的括号
public class P20_ValidParentheses {

    public static void main(String[] args) {

        Solution solution = new P20_ValidParentheses().new Solution();
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("{()}"));
        System.out.println(solution.isValid("{[()]}"));
        System.out.println(solution.isValid("{[()}]"));
        System.out.println(solution.isValid("{["));
        System.out.println(solution.isValid(")"));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isValid(String s) {
            //            return useEqual(s);
            return useEqual2(s);
        }


        private boolean useEqual(String s) {
            Deque<Character> deque = new ArrayDeque();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '{' || c == '[') {
                    deque.push(c);
                }else if (c == ')' || c == '}' || c == ']') {
                    if (deque.isEmpty()) {
                        return false;
                    }
                    Character top = deque.poll();
                    if (c == ')' && top == '(' || c == '}' && top == '{' || c == ']' && top == '[') {
                        continue;
                    }
                    return false;
                    //都不是
                }else {
                    return false;
                }

            }
            return deque.isEmpty();
        }


        private boolean useEqual2(String s) {
            Deque<Character> deque = new ArrayDeque();

            HashMap<Character, Character> chars = new HashMap<Character, Character>() {{
                put('(', ')');
                put('{', '}');
                put('[', ']');

            }};

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                boolean isLeft = chars.keySet().contains(c);
                boolean isRight = chars.values().contains(c);
                if (isLeft) {
                    deque.push(c);
                }else if (isRight) {
                    if (deque.size() > 0 && chars.get(deque.poll()).equals(c)) {
                        continue;
                    }
                    return false;
                    //都不是
                }else {
                    return false;
                }

            }
            return deque.isEmpty();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}