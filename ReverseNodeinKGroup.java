public class ReverseNodeinKGroup {

    class Solution {
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


    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
