import java.util.Stack;

class StockSpanner {
    // A stack to store arrays of size 2: [price, span]
    private Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        
        // While the stack is not empty and the previous price is less than or equal to current price
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            // Add the span of the popped element to our current span
            span += stack.pop()[1];
        }
        
        // Push the current price and its accumulated span onto the stack
        stack.push(new int[] { price, span });
        
        return span;
    }
}