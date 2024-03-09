package amw.radczu.lab2

// Bubble-sort malejący
class BubbleSortingDesc: ISortingStrategy {
    override fun run(array: IntArray): IntArray {
        // Sortuj do całkowitej posortowanej tablicy
        var sorted = false
        while(!sorted) {
            var swaps = 0
            // Zamień miejscami sąsiednie wartości gdy są nieposortowane
            for(i in 0 until array.size - 1) {
                if(array[i] < array[i+1]) {
                    val temp = array[i]
                    array[i] = array[i+1]
                    array[i + 1] = temp
                    swaps++
                }
            }
            if(swaps == 0) sorted = true
        }
        return array
    }
}