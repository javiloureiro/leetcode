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
    public void reorderList(ListNode head) {
        List<ListNode> lista = new ArrayList<>();
        ListNode curr = head;

        while (curr != null) {
            lista.add(curr);
            curr = curr.next;
        }

        int i = 0, j = lista.size() - 1;
        while (i < j) {
            lista.get(i).next = lista.get(j);
            i++;
            if (i == j) break;
            lista.get(j).next = lista.get(i);
            j--;
        }
        lista.get(i).next = null;


    }
}
