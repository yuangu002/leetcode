package array;

import common.ListNode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        int carry;
        if (l1.val+l2.val > 9) carry = 1;
        else carry = 0;
        ListNode fake = new ListNode(0);
        ListNode cur = new ListNode((l1.val+l2.val)%10);
        fake.next = cur;

        while (l1.next != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
            cur.next = new ListNode((l1.val+l2.val+carry)%10);
            cur = cur.next;
            if (l1.val+l2.val+carry > 9) carry = 1;
            else carry = 0;
        }

        while (l1.next != null){
            l1 = l1.next;
            cur.next = new ListNode((l1.val+carry)%10);
            cur = cur.next;
            if (l1.val+carry > 9) carry = 1;
            else carry = 0;
        }

        while (l2.next != null){
            l2 = l2.next;
            cur.next = new ListNode((l2.val+carry)%10);
            cur = cur.next;
            if (l2.val+carry > 9) carry = 1;
            else carry = 0;
        }

        if (carry == 1) cur.next = new ListNode(1);

        return fake.next;
    }
}
