package com.autismbug.leetcode.preadd


/**
 * 560. 和为K的子数组
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 *
 * 给定一个二维矩阵 matrix，以下类型的多个请求：
 *
 * 计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1,col1) ，右下角为 (row2,col2) 。
 * 实现 NumMatrix 类：
 *
 * NumMatrix(int[][] matrix)给定整数矩阵 matrix 进行初始化
 * int sumRegion(int row1, int col1, int row2, int col2)返回左上角 (row1,col1)、右下角(row2,col2)的子矩阵的元素总和。
 *
 *
 * 输入:
 * ["NumMatrix","sumRegion","sumRegion","sumRegion"]
 * [[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]
 *
 * 输出:
 * [null, 8, 11, 12]
 *
 * 解释:
 * NumMatrix numMatrix = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]]);
 * numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
 * numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
 * numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution304(matrix: Array<IntArray>) {
    private val sumMatrix: Array<IntArray?> = arrayOfNulls(matrix.size)
    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        return sum(row2, col2) - sum(row2, col1 - 1) - sum(row1 - 1, col2) + sum(row1 - 1, col1 - 1)
    }

    private fun sum(row: Int, col: Int): Int {
        return if (row < 0 || col < 0) {
            0
        } else sumMatrix[row]!![col]
    }

    init {
        for (row in matrix.indices) {
            sumMatrix[row] = IntArray(matrix[0].size)
            for (column in 0 until matrix[0].size) {
                var sumLeft = 0
                var sumTop = 0
                var sumDiagonal = 0
                if (column > 0) {
                    sumLeft = sumMatrix[row]!![column - 1]
                }
                if (row > 0) {
                    sumTop = sumMatrix[row - 1]!![column]
                }
                if (row > 0 && column > 0) {
                    sumDiagonal = sumMatrix[row - 1]!![column - 1]
                }
                sumMatrix[row]!![column] = sumLeft + sumTop - sumDiagonal + matrix[row][column]
            }
        }
    }
}

fun main() {

}