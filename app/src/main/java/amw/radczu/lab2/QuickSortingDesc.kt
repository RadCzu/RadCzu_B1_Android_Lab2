package amw.radczu.lab2

class QuickSortingDesc: ISortingStrategy {
    override fun run(array: IntArray): IntArray {
        quicksort(array, 0, array.size - 1)
        return array
    }

    private fun quicksort(array: IntArray, l: Int, r: Int) {
        if (l < r) {
            val splitArray = splitArray(array, l, r)
            quicksort(array, l, splitArray - 1)
            quicksort(array, splitArray + 1, r)
        }
    }

    private fun splitArray(array: IntArray, leftBoundaryIndex: Int, rightBoundaryIndex: Int): Int {
        val splitIndex = leftBoundaryIndex + (rightBoundaryIndex - leftBoundaryIndex) / 2
        val splitValue = array[splitIndex]
        swap(array, splitIndex, rightBoundaryIndex)

        var currentPosition = leftBoundaryIndex
        for (i in leftBoundaryIndex until rightBoundaryIndex) {
            if (array[i] > splitValue) { // Change the comparison to >
                swap(array, i, currentPosition)
                currentPosition++
            }
        }
        swap(array, currentPosition, rightBoundaryIndex)
        return currentPosition
    }

    private fun swap(array: IntArray, index1: Int, index2: Int) {
        val temp = array[index1]
        array[index1] = array[index2]
        array[index2] = temp
    }
}