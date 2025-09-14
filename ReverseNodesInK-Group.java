class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        int count = 0;
        ListNode ptr = head;
        while (ptr != null) {
            count++;
            ptr = ptr.next;
        }

        while (count >= k) {
            ListNode curr = prevGroupEnd.next;
            ListNode next = null;
            ListNode prev = null;

            for (int i = 0; i < k; i++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            ListNode groupStart = prevGroupEnd.next;
            prevGroupEnd.next = prev;
            groupStart.next = curr;

           
            prevGroupEnd = groupStart;

            count -= k;
        }

        return dummy.next;
    }
}
