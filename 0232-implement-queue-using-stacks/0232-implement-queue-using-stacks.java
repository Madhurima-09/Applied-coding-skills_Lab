import java.util.Stack;

class MyQueue {
    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }
    
    public void push(int x) {
        // Always push new elements to the input stack
        inputStack.push(x);
    }
    
    public int pop() {
        // Ensure outputStack has the elements ready
        shiftStacks();
        return outputStack.pop();
    }
    
    public int peek() {
        // Ensure outputStack has the elements ready
        shiftStacks();
        return outputStack.peek();
    }
    
    public boolean empty() {
        // The queue is empty only if both stacks are empty
        return inputStack.isEmpty() && outputStack.isEmpty();
    }
    
    // Helper method to move elements from inputStack to outputStack when needed
    private void shiftStacks() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
    }
}