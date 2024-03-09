package linkedlist;

import common.ListNode;

public class ReverseNodeinKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = head;
        ListNode cur = head;
        for (int i = 0; i < k; ++i) {
            if (cur == null) {
                return head;
            }
            cur = cur.next;
        }
        ListNode rev = reverse(head, cur);
        ListNode rest = reverseKGroup(cur, k);
        
        prev.next = rest;
        return rev;
    }
    
    /**
     * Memorize this!
     * Reverse a linked list from node A to node B.
     * Return the head of the reversed linked list
     * A -> C -> D -> B
     * ^    ^
     * prev cur
     * tmp = D -> B
     * C -> D -> B
     */
    private ListNode reverse(ListNode a, ListNode b) {
        ListNode prev = null, cur = a;
        
        while (cur != b) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        
        return prev;
    }
}
