package linkedlist;

import common.ListNode;

/**
 * Given a Circular Linked List node, which is sorted in non-descending order,
 * write a function to insert a value insertVal
 * into the list such that it remains a sorted circular list. The given node can
 * be a reference to any single node in the list
 * and may not necessarily be the smallest value in the circular list.
 * 
 * If there are multiple suitable places for insertion, you may choose any place
 * to insert the new value.
 * After the insertion, the circular list should remain sorted.
 * 
 * If the list is empty (i.e., the given node is null), you should create a new
 * single circular list and return the reference
 * to that single node. Otherwise, you should return the originally given node.
 */
public class InsertCircularSortedLinkedList {
    public ListNode insert(ListNode head, int insertVal) {
        if (head == null) {
            ListNode r = new ListNode(insertVal);
            r.next = r;
            return r;
        }

        ListNode curNode = head;
        while (true) {
            if (isMiddleValue(curNode, curNode.next, insertVal) || isExtremeValue(curNode, curNode.next, insertVal)
                    || curNode.next == head) {
                ListNode r = new ListNode(insertVal);
                r.next = curNode.next;
                curNode.next = r;
                break;
            }
            curNode = curNode.next;
        }
        return head;
    }

    public boolean isMiddleValue(ListNode curNode, ListNode nextNode, int insertVal) {
        return insertVal > curNode.val && insertVal <= nextNode.val;
    }

    public boolean isExtremeValue(ListNode curNode, ListNode nextNode, int insertVal) {
        return nextNode.val < curNode.val && (insertVal <= nextNode.val || insertVal >= curNode.val);
    }
}
