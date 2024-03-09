package linkedlist;

import common.ListNode;

public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode cur=head, cur2=head;
        int size = 1;
        while (cur.next != null){
            cur = cur.next;
            size++;
        }
        if (n == size) {
            return head.next;
        }
        int index = size - n;
        while (index > 1){
            cur2 = cur2.next;
            index--;
        }
        cur2.next = cur2.next.next;
        return head;
    }
}
