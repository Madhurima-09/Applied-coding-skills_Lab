class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cursor = head;
        int count = 0;
        while (cursor != null && count < k)
{
    cursor = cursor.next;
    count++;
    }
    if (count == k) {
        ListNode curr = head, prev = null, nxt = null;
        for(int i = 0; i<k; i++){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        head.next = reverseKGroup(curr, k);
        return prev;
    }
    return head;
}
}