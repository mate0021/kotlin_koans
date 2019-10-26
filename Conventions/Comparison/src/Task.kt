data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override operator fun compareTo(other: MyDate): Int {
        if (year < other.year) {
            return -1
        } else if (year == other.year && month < other.month) {
            return -1
        } else if (year == other.year && month == other.month && dayOfMonth < other.dayOfMonth) {
            return -1
        } else if (year == other.year && month == other.month && dayOfMonth == other.dayOfMonth) {
            return 0
        } else {
            return 1
        }

    }
}

fun compare(date1: MyDate, date2: MyDate) = date1 < date2

/*
    override fun compareTo(other: MyDate) = when {
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
    }

 */