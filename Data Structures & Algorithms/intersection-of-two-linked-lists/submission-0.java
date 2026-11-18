/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = getSize(headA); // 5
        int sizeB = getSize(headB); // 6
        
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (sizeB > sizeA) {
            // Get b up to speed, so both can start the same
            sizeB--;
            tempB = tempB.next;
        }

        while (sizeA > sizeB) {
            // Get a up to speed, so both can start the same
            sizeA--;
            tempA = tempA.next;
        }

        while (tempA != null && tempB != null) {
            if (tempA == tempB) return tempA;
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return null;
    }

    private int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        return size;
    }
}


