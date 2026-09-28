public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Base case: if either list is empty, there is no intersection
        if (headA == null || headB == null) {
            return null;
        }
        
        ListNode pA = headA;
        ListNode pB = headB;
        
        // Traverse both lists. When a pointer reaches the end, 
        // redirect it to the head of the other list.
        while (pA != pB) {
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }
        
        // Either the intersection node or null (if they don't intersect)
        return pA;
    }
}