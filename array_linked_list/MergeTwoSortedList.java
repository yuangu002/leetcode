package array_linked_list;

import common.ListNode;

public class MergeTwoSortedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // special cases
        if (l1 == null && l2 == null) return null;
        else if (l1 == null) return l2;
        else if (l2 == null) return l1;

        // set up the head node
        ListNode dummy = new ListNode(0);
        ListNode curAll, cur1 = l1, cur2 = l2;
        if (l1.val < l2.val) {
            curAll = new ListNode(l1.val);
            cur1 = cur1.next;
            dummy.next = curAll;
        }
        else if (l1.val > l2.val) {
            curAll = new ListNode(l2.val);
            cur2 = cur2.next;
            dummy.next = curAll;
        }
        else {
            curAll = new ListNode(l1.val);
            curAll.next = new ListNode(l2.val);
            cur1 = cur1.next;
            cur2 = cur2.next;
            dummy.next = curAll;
            curAll = curAll.next;
        }

        while (cur1 != null && cur2 != null){
            if (cur1.val < cur2.val){
                curAll.next = new ListNode(cur1.val);
                cur1 = cur1.next;
                curAll = curAll.next;
            }
            else if (cur1.val > cur2.val){
                curAll.next = new ListNode(cur2.val);
                cur2 = cur2.next;
                curAll = curAll.next;
            }
            else {
                curAll.next = new ListNode(cur1.val);
                curAll.next.next = new ListNode(cur2.val);
                cur1 = cur1.next;
                cur2 = cur2.next;
                curAll = curAll.next.next;
            }
        }

        while (cur1 != null){
            curAll.next = new ListNode(cur1.val);
            cur1 = cur1.next;
            curAll = curAll.next;
        }
        while (cur2 != null){
            curAll.next = new ListNode(cur2.val);
            cur2 = cur2.next;
            curAll = curAll.next;
        }
        return dummy.next;
    }
}

