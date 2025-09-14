/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        ListNode curr = head;

        while(curr != null){
            list.add(curr);
            curr = curr.next;
        }

        int posEliminar = list.size()-n;

        ListNode nodoEliminar = list.get(posEliminar);
        nodoEliminar = null;

        if (posEliminar == 0) {
            head = head.next;
        } else {
            list.get(posEliminar - 1).next = (posEliminar + 1 < list.size()) 
            ? list.get(posEliminar + 1) : null;
        }

        return head;
    }
}
