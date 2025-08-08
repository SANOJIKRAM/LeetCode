/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        int count=0;
        ListNode head_backup=head;
        while(head_backup!=null)
        {
            count++;
            head_backup=head_backup.next;
        }
        int midpos=count/2;

        for(int pos=0;head!=null && pos<midpos;pos++)
        {
            head=head.next;
        }
          return head;
    }
}