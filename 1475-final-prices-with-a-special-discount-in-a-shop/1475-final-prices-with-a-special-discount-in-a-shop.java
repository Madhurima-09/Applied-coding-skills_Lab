import java.util.Stack;

class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        // Clone prices so items without a discount retain their original price
        int[] answer = prices.clone(); 
        Stack<Integer> stack = new Stack<>(); // Stores indices of prices
        
        for (int i = 0; i < n; i++) {
            // While the stack is not empty and the current price is less than 
            // or equal to the price at the index on top of the stack
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int idx = stack.pop();
                answer[idx] = prices[idx] - prices[i]; // Apply the discount
            }
            // Push the current index onto the stack
            stack.push(i);
        }
        
        return answer;
    }
}