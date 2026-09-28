

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        
        // Phase 1: Determine if a cycle exists using Tortoise and Hare
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        
        // If no cycle was found, return null
        if (!hasCycle) {
            return null;
        }
        
        // Phase 2: Find the exact entrance to the cycle
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow; // The node where the cycle begins
    }
}