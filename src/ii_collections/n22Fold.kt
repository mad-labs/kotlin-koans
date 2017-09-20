package ii_collections

fun example9() {
    val result = listOf(1, 2, 3, 4).fold(1, { partResult, element -> element * partResult })
    result == 24
}

// The same as
fun whatFoldDoes(): Int {
    var result = 1
    listOf(1, 2, 3, 4).forEach { element -> result = element * result}
    return result
}

fun Shop.getSetOfProductsOrderedByEveryCustomer(): Set<Product> {
    // Return the set of products ordered by every customer
    return customers.fold(allOrderedProducts, { //here starts with all elements
        orderedByAll, customer ->
            orderedByAll.intersect(customer.orderedProducts) //than reduce items found in a customer products
    })
}

//why it works:
fun main(args: Array<String>) {
    val aFisrtSet = setOf(1, 2, 4)
    val aSecondSet = setOf(0, 2, 3)

    val aThirdSet = setOf(2)
    val allItems = aFisrtSet.plus(aSecondSet).plus(aThirdSet)
    val allSets = setOf(aFisrtSet, aSecondSet, aThirdSet)
    println("aFisrtSet: " + aFisrtSet + ", aSecondSet: " + aSecondSet + ", anEmptySet: " + aThirdSet + "")
    println("aFisrtSet.intersect(aSecondSet): " + aFisrtSet.intersect(aSecondSet) + "")
    println("aFisrtSet.intersect(aSecondSet).intersect(aThirdSet): " + aFisrtSet.intersect(aSecondSet).intersect(aThirdSet) + "")

    //it starts with all elements
    val resfold = allSets.fold(allItems, {
        orderedByAll, aSet ->
        orderedByAll.intersect(aSet)
    })
    println("resfold :" + resfold)

    val anEmtySet = emptySet<Int>()
    val allItems2 = allItems.plus(anEmtySet)
    val allSets2 = setOf(aFisrtSet, aSecondSet, aThirdSet, anEmtySet)
    println("aFisrtSet.intersect(aSecondSet).intersect(aThirdSet).intersect(anEmtySet): " + aFisrtSet.intersect(aSecondSet).intersect(aThirdSet).intersect(anEmtySet) + "")

    //it starts with all elements
    val resfold2 = allSets2.fold(allItems2, {
        orderedByAll, aSet ->
        orderedByAll.intersect(aSet)
    })
    println("resfold2 :" + resfold2)
}
