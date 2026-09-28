import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0; // Pointer to track the current element to pop
        
        for (int val : pushed) {
            stack.push(val);
            
            // While the stack is not empty and the top of the stack matches 
            // the expected element in the popped array, pop it and move the pointer forward.
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        
        // If the stack is empty, all elements were successfully popped in the correct order
        return stack.isEmpty();
    }
}