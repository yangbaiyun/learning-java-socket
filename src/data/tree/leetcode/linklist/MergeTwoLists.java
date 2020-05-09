package data.tree.leetcode.linklist;

import org.junit.Test;

/**
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoLists {


    @Test
    public void test()
    {

        ListNode l1=new ListNode(1);
        ListNode l11=new ListNode(2);
        ListNode l12=new ListNode(4);

        l1.next = l11;
        l11.next = l12;

        ListNode l2=new ListNode(1);
        ListNode l21=new ListNode(3);
        ListNode l22=new ListNode(4);

        l2.next = l21;
        l21.next = l22;

        mergeTwoLists(l1,l2);


    }


    public  ListNode mergeTwoLists(ListNode l1, ListNode l2) {



        ListNode p = new ListNode(0);
        ListNode threeHead = p;

        while(l1!=null && l2!=null)
        {

            if(l1.val<=l2.val)
            {

                p.next = l1;
                l1 = l1.next;
            }
            else if(l1.val>l2.val)
            {
                p.next = l2;
                l2 = l2.next;
            }


            p = p.next;
        }

        while (l1!=null)
        {
            p.next = l1;
            p = p.next;
            l1 = l1.next;
        }

        while (l2!=null)
        {
            p.next = l2;
            p = p.next;
            l2 = l2.next;
        }

        return threeHead.next;

    }



    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
