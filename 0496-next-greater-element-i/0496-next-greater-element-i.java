import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        // Step 1: Traverse nums2 to find the next greater element for each number
        for (int num : nums2) {
            // If the current number is greater than the top of the stack,
            // it is the "next greater element" for that stack element.
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreaterMap.put(stack.pop(), num);
            }
            stack.push(num);
        }
        
        // Step 2: Build the result array for nums1 using the map
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            // If a number isn't in the map, it means it had no next greater element (-1)
            ans[i] = nextGreaterMap.getOrDefault(nums1[i], -1);
        }
        
        return ans;
    }
}