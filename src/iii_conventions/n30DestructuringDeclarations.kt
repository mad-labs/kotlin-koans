package iii_conventions.multiAssignemnt

import util.TODO
import util.doc30

fun todoTask30(): Nothing = TODO(
    """
        Task 30.
        Read about destructuring declarations and make the following code compile by adding one 'data' modifier.
    """,
    documentation = doc30()
)

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

fun isLeapDay(date: MyDate): Boolean {
//    todoTask30()
    val (year, month, dayOfMonth) = date

    // 29 February of a leap year
    return year % 4 == 0 && month == 2 && dayOfMonth == 29
}

fun MyDate.lambaTest(detructuredToString: (one: Int, two: Int, tree: Int) -> String): String {
    return detructuredToString(year, month, dayOfMonth)
}

fun main(args: Array<String>) {
    println(MyDate(0, 12, 29).lambaTest(
            { a: Int, b: Int, c: Int -> "~number of days from year 0: " + (a * 365 + monthsToDays(b) + c )}
    ))
}

fun monthsToDays(month: Int) : Int {
    var acc = 0
    (0..month).forEach { i ->
        acc += when(i){
            1, 3, 5, 7, 8, 10 -> 31
            2 -> 28
            4, 6, 9, 11 -> 30
            else -> 0
        }
    }
    return acc
}