package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {

    override fun compareTo(other: MyDate): Int {
        return (this.year * 10000 + this.month * 100 + this.dayOfMonth) - (other.year * 10000 + other.month * 100 + other.dayOfMonth)
    }

}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)
operator fun MyDate.plus(interval: TimeInterval) = this.addTimeIntervals(interval, 1)
operator fun MyDate.plus(intervals: MultipleTimeIntervals) = this.addTimeIntervals(intervals.interval, intervals.times)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class MultipleTimeIntervals(val interval: TimeInterval, val times: Int)
operator fun TimeInterval.times(times: Int) = MultipleTimeIntervals(this, times)


class DateRange(val start: MyDate, val endInclusive: MyDate) : Iterable<MyDate> {
    override fun iterator() = DateRangeIterator(this)

    operator fun contains(dateToCheck: MyDate) = start <= dateToCheck && dateToCheck <= endInclusive
}

class DateRangeIterator(val range: DateRange) : Iterator<MyDate> {

    var currentDate = range.start

    override operator fun next(): MyDate {
        val next = currentDate;
        currentDate = currentDate.nextDay()
        return next
    }

    override operator fun hasNext(): Boolean {
        return currentDate <= range.endInclusive
    }
}