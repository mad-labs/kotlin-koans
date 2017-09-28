fun main(args: Array<String>) {
    val arrayDimension : List<Long> = tokenizedInput({ it.toLong() })
    val numbers : List<Long> = tokenizedInput({ it.toLong() })
    println("${numbers.fold(0L,{ sum, number -> sum + number})}")
}

fun <R> tokenizedInput(op: (String) -> R) : List<R> {
    val input = readLine() ?: ""
    return input.split(" ").map(op)
}
