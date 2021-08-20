package com.autismbug.leetcode.list.fastslow

/**
 * 283. 移动零
 * https://leetcode-cn.com/problems/remove-element/
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution283 {
    fun moveZeroes(nums: IntArray): Unit {
        var fast = 0
        var slow = 0
        while (fast < nums.size) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast]
                slow++
            }
            fast++
        }
        while (slow < nums.size) {
            nums[slow] = 0
            slow++
        }
    }
}


fun main() {
    val nums = intArrayOf(0, 1, 0, 3, 12)
    Solution283().moveZeroes(nums)
    for (num in nums) {
        println("num = $num")
    }
}