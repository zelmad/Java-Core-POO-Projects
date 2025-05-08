package com.zelmad.algorithmes.leetcode;

public class AddTwoNumbers {
    static ListNode l1 = new ListNode(9);
    static ListNode l2 = new ListNode(9);
    public static void main(String[] args) {

        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);

        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);

        Solution solution = new Solution();
        ListNode node = solution.addTwoNumbers(l1, l2);

        while(node != null && node.next != null) {
            System.out.println(node.val);
            node = node.next;
        }
        System.out.println(node.val);
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int rest = 0;
            ListNode result = new ListNode(0);
            ListNode curr = result;
            while(l1 != null || l2 != null) {
                int l1Val = (l1 != null) ? l1.val : 0;
                int l2Val = (l2 != null) ? l2.val : 0;
                int sum = l1Val + l2Val + rest;
                rest = sum/10;
                curr.next = new ListNode(sum%10);
                l1 = (l1 != null) ? l1.next : null;
                l2 = (l2 != null) ? l2.next : null;
                curr = curr.next;
            }
            if(rest != 0)
                curr.next = new ListNode(rest);
            return result.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
}