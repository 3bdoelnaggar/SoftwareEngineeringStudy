package practice

class BigSorting {
    fun bigSorting(unsorted: Array<String>): Array<String> {
        unsorted.sortWith(sortComparable)
        return unsorted
    }

    private val sortComparable = Comparator<String> { one, two ->
        if (one.length < two.length) return@Comparator -1
        if (one.length > two.length) return@Comparator 1

        val maxIntDigit = 9
        if (one.length <= maxIntDigit) {
            return@Comparator one.toInt().compareTo(two.toInt())
        } else {
            val maxLongDigit = 19
            if (one.length <= maxLongDigit) {
                return@Comparator one.toLong().compareTo(two.toLong())
            } else {
                var start = 0
                var end = 19
                while (end < one.length && start < end) {
                    val oneLong = one.substring(start until end).toLong()
                    val twoLong = two.substring(start until end).toLong()
                    val compare = oneLong.compareTo(twoLong)
                    if (compare != 0) {
                        return@Comparator compare
                    }
                    start = end
                    end = minOf(end + 19, one.length - 1)
                }
            }
        }
        return@Comparator 0
    }
}