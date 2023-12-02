package array_linked_list;

public class RemoveNthNode {

    public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    class Solution {
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
}