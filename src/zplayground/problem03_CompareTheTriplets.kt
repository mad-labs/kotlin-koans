
fun main(args: Array<String>) {

    val aPoints = parseStringNumbers(readLine()?:"")
    val bPoints = parseStringNumbers(readLine()?:"")

    val (aScore, bScore) = calculateScores(aPoints, bPoints)

    println("$aScore $bScore")
}

fun parseStringNumbers(stringNumbers: String) : List<Int>{
    return stringNumbers.split(" ").map(String::toInt)
}

fun calculateScores(aPoints: List<Int>, bPoints: List<Int>) : Pair<Int, Int>{
    val zippedPoints: List<Pair<Int, Int>> = aPoints.zip(bPoints);
    val results = zippedPoints.fold(Pair(0,0), { res, points -> when {
        points.first > points.second -> Pair(res.first + 1, res.second)
        points.first < points.second -> Pair(res.first, res.second + 1)
        else  -> res
    }})
    return results
}
