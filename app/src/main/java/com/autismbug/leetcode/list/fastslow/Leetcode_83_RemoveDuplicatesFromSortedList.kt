package com.autismbug.leetcode

/**
 * 83. 删除排序链表中的重复元素
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 *
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * 返回同样按升序排列的结果链表。
 *
 * 示例:
 *
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution83 {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head == null)
            return null
        var slow = head
        var fast = head
        while (fast != null) {
            // 快指针不为 null ,慢指针必不为 null
            if (fast.value != slow!!.value) {
                slow.next = fast
                slow = slow.next
            }
            fast = fast.next
        }
        // 断开与后面重复元素的连接
        slow!!.next = null
        return head
    }
}

class ListNode(var value: Int) {
    var next: ListNode? = null
}

fun main() {
    val node1 = ListNode(1)
    val node2 = ListNode(1)
    val node3 = ListNode(2)
    node1.next = node2
    node2.next = node3

    var resultNode = Solution83().deleteDuplicates(node1)
    while (resultNode?.value!=null){
        println(resultNode.value)
        resultNode = resultNode.next
    }
}