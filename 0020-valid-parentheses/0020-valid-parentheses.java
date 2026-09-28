import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            // If it's an opening bracket, push it to the stack
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } 
            // If it's a closing bracket
            else {
                // If stack is empty or the top doesn't match the expected closing bracket
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        
        // If the stack is empty, all opening brackets were correctly closed
        return stack.isEmpty();
    }
}