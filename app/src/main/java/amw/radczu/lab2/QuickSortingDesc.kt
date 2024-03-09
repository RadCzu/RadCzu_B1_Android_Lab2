package amw.radczu.lab2

// Quicksort malejący
class QuickSortingDesc: ISortingStrategy {
    override fun run(array: IntArray): IntArray {
        quicksort(array, 0, array.size - 1)
        return array
    }
    private fun quicksort(array: IntArray, l: Int, r: Int) {
        // Wyznacz środkowy indeks i posortuj połówki tablicy
        if (l < r) {
            val splitArray = splitArray(array, l, r)
            quicksort(array, l, splitArray - 1)
            quicksort(array, splitArray + 1, r)
        }
    }
    private fun splitArray(array: IntArray, leftBoundaryIndex: Int, rightBoundaryIndex: Int): Int {
        val splitIndex = leftBoundaryIndex + (rightBoundaryIndex - leftBoundaryIndex) / 2
        val splitValue = array[splitIndex]

        // Zamień środkowy element z prawym
        swap(array, splitIndex, rightBoundaryIndex)

        // Zamieniaj indeksy większe od wcześniejszego środkowego a następnie szukaj dalej
        var currentPosition = leftBoundaryIndex
        for (i in leftBoundaryIndex until rightBoundaryIndex) {
            if (array[i] > splitValue) {
                swap(array, i, currentPosition)
                currentPosition++
            }
        }
        // Wróć środkowy indeks na swoje miejsce
        swap(array, currentPosition, rightBoundaryIndex)
        return currentPosition
    }

    private fun swap(array: IntArray, index1: Int, index2: Int) {
        val temp = array[index1]
        array[index1] = array[index2]
        array[index2] = temp
    }
}