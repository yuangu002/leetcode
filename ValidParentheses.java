import java.util.*;

public class ValidParentheses {
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            HashMap<Character, Character> match = new HashMap<>();
            match.put(')', '(');
            match.put(']', '[');
            match.put('}', '{');
            for (int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if (c == '(' || c == '{' || c == '[') stack.push(c);
                else if (c == ')' || c == '}' || c == ']'){
                    Character expected = match.get(c);
                    char left = ' ';
                    if (!stack.isEmpty()) left = stack.pop();
                    if (left != expected) return false;
                }
            }
            return stack.isEmpty();
        }

        
        public boolean isValid2(String s){
            char[] stack = new char[s.length()];
            int ptr = 0;
            for (char c: s.toCharArray()){
                switch (c){
                    case '(':
                    case '{':
                    case '[':
                        stack[ptr++] = c;
                        break;
                    case ')':
                        if (ptr == 0 || stack[--ptr] != '(') return false;
                        break;
                    case '}':
                        if (ptr == 0 || stack[--ptr] != '{') return false;
                        break;
                    case ']':
                        if (ptr == 0 || stack[--ptr] != '[') return false;
                        break;
                }
            }
            return ptr==0;
        }
    }
}
