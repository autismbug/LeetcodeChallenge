package com.autismbug.leetcode.list.fastslow

/**
 * 1. 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution1 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        for (num1Index in nums.indices) {
            map[target - nums[num1Index]]?.let { num2Index ->
                return intArrayOf(num2Index, num1Index)
            }
            map[nums[num1Index]] = num1Index
        }
        return intArrayOf()
    }
}

fun main() {
    val src = intArrayOf(2, 7, 11, 15)
    val target = 9
    val twoSum = Solution1().twoSum(src, target)
    for (i in twoSum) {
        println("twoSumIndex = $i")
    }
}