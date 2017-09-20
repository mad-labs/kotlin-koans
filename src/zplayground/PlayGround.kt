import ii_collections.allOrderedProducts
import ii_collections.orderedProducts

fun main(args: Array<String>) {
    val aFisrtSet = setOf(1, 2, 4)
    val aSecondSet = setOf(0, 2, 3)
    val aThirdSet = setOf(2)
    val allItems = aFisrtSet.plus(aSecondSet).plus(aThirdSet)
    val allSets = setOf(aFisrtSet, aSecondSet, aThirdSet)
    println("aFisrtSet: " + aFisrtSet + ", aSecondSet: " + aSecondSet + ", anEmptySet: " + aThirdSet + "")
    println("aFisrtSet.intersect(aSecondSet): " + aFisrtSet.intersect(aSecondSet) + "")
    println("aFisrtSet.intersect(aSecondSet).intersect(aThirdSet): " + aFisrtSet.intersect(aSecondSet).intersect(aThirdSet) + "")
    val res = allSets.fold(allItems, {
        orderedByAll, aSet ->
        orderedByAll.intersect(aSet)
    })
    println("res :" + res)
}