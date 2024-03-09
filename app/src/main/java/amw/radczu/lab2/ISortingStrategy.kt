package amw.radczu.lab2

// Wzorzec projektowy typu: Strategy
interface ISortingStrategy {
    fun run(array: IntArray): IntArray
}