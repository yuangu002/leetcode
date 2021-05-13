import java.util.*;


public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((l1, l2) -> l1.val - l2.val);
        
        ListNode dummy = new ListNode(0);
        ListNode curnode = dummy;
        for (ListNode node: lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        while (!pq.isEmpty()) {
            ListNode min_node = pq.poll();
            curnode.next = new ListNode(min_node.val);
            curnode = curnode.next;
            if (min_node.next != null) {
                pq.offer(min_node.next);
            }
        }
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
