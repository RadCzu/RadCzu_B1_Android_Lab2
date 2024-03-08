package amw.radczu.lab2

class BubbleSortingDesc: ISortingStrategy {
    override fun run(array: IntArray): IntArray {
        var sorted = false;
        while(!sorted) {
            var swaps = 0
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