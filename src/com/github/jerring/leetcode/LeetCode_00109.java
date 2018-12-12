package com.github.jerring.leetcode;

public class LeetCode_00109 {

    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head, null);
    }

    /**
     * 每次找中间结点来构建二叉树，这样可以保证构建得到的二叉搜索树一定是平衡的二叉搜索树。
     * 可以利用快慢指针来找中间结点，注意链表结点总数奇偶性的差异（对本题没有影响）。
     * 为偶数时，fast 指针不能再前进时，fast 指向 null，slow 指向下中位数的结点。
     * 为奇数时，fast 指针不能再前进时，fast 指向尾结点，slow 指向中心结点。
     * @param head  头结点
     * @param end   尾结点的下一个结点
     * @return      二叉树的根结点
     */
    private TreeNode sortedListToBST(ListNode head, ListNode end) {
        if (head == end) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != end && fast.next != end) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head, slow);
        root.right = sortedListToBST(slow.next, end);
        return root;
    }
}
