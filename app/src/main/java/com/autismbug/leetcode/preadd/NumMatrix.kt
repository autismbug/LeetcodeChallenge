package com.autismbug.leetcode.preadd

internal class NumMatrix(matrix: Array<IntArray>) {
    private val sumMatrix: Array<IntArray?>
    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        return sum(row2, col2) - sum(row2, col1 - 1) - sum(row1 - 1, col2) + sum(row1 - 1, col1 - 1)
    }

    private fun sum(row: Int, col: Int): Int {
        return if (row < 0 || col < 0) {
            0
        } else sumMatrix[row]!![col]
    }

    init {
        sumMatrix = arrayOfNulls(matrix.size)
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