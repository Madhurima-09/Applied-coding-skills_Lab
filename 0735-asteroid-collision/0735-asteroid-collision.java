import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int ast : asteroids) {
            boolean destroyed = false;
            
            // Collision happens only if the stack top is moving right (> 0) 
            // and the current asteroid is moving left (< 0)
            while (!stack.isEmpty() && stack.peek() > 0 && ast < 0) {
                int top = stack.peek();
                
                if (Math.abs(top) < Math.abs(ast)) {
                    // Top asteroid is smaller, it explodes; continue checking against next in stack
                    stack.pop();
                    continue;
                } else if (Math.abs(top) == Math.abs(ast)) {
                    // Both are same size, both explode
                    stack.pop();
                }
                // If top asteroid is larger, current asteroid explodes
                destroyed = true;
                break;
            }
            
            // If the current asteroid survived all collisions, push it to the stack
            if (!destroyed) {
                stack.push(ast);
            }
        }
        
        // Convert the stack to an array for the final output
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }
}