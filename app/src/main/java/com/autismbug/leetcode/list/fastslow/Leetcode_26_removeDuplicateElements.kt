package com.autismbug.leetcode.list.fastslow

/**
 * 26. 删除有序数组中的重复项
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution26 {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        var slow = 0
        var fast = 0
        while (fast < nums.size) {
            if (nums[slow] != nums[fast]) {
                slow++
                nums[slow] = nums[fast]
            }
            fast++
        }
        // 数组长度 索引 + 1
        return slow + 1
    }
}

fun main() {
    val src = intArrayOf(1, 1, 2)
    val size = Solution26().removeDuplicates(src)
    for (i in src) {
        println("i = $i")
    }
    println("size = $size")
}