import java.util.Stack;

class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>(); // Stores indices of '('
        
        // Pass 1: Identify and mark invalid closing and opening parentheses
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop(); // Found a match for this closing parenthesis
                } else {
                    sb.setCharAt(i, '*'); // Mark invalid ')' for removal
                }
            }
        }
        
        // Any remaining '(' in the stack are unmatched and invalid
        while (!stack.isEmpty()) {
            sb.setCharAt(stack.pop(), '*');
        }
        
        // Pass 2: Build the final string by omitting all marked characters ('*')
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c != '*') {
                result.append(c);
            }
        }
        
        return result.toString();
    }
}