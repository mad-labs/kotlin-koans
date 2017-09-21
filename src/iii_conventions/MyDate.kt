package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate>{

    override fun compareTo(other: MyDate): Int {
        return (this.year*10000+this.month*100+this.dayOfMonth) - (other.year*10000+other.month*100+other.dayOfMonth)
    }

}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate){
    operator fun contains(dateToCheck: MyDate) = start <= dateToCheck && dateToCheck <= endInclusive
}