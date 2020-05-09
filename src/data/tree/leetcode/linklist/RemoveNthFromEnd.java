package data.tree.leetcode.linklist;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 */
public class RemoveNthFromEnd {




    public ListNode removeNthFromEnd(ListNode head, int n) {


        if(head.next == null)
            return null;

        List<ListNode> nodes = new LinkedList();
        ListNode cur = head;
        while(cur!=null)
        {
            nodes.add(cur);
            cur = cur.next;
        }

        int length = nodes.size();

        if(length-n-1 < 0)//删除的头节点
        {
            head = head.next;

        }else
        {
            nodes.get(length-n-1).next = nodes.get(length-n).next;
            nodes.get(length-n).next = null;
        }




        return head;


    }



    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
