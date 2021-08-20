package com.autismbug.leetcode.preadd


/**
 * 560. 和为K的子数组
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 *
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution560 {
    fun subarraySum(nums: IntArray, k: Int): Int {
        // 前缀和数组
        val preSum = IntArray(nums.size + 1)
        for (i in nums.indices) {
            preSum[i + 1] = preSum[i] + nums[i]
        }

        // 遍历所有的元素组合, 通过前缀和数组判断差值
        var count = 0
        for (left in nums.indices) {
            for (right in left until nums.size) {
                if (preSum[right + 1] - preSum[left] == k) {
                    count++
                }
            }
        }
        return count
    }
}

fun main() {
    val nums = intArrayOf(1, 1, 1,-1)
    val k = 2
    val subarraySum = Solution560().subarraySum(nums, k)
    println("subarraySum = $subarraySum")
}