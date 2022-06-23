package practice

//https://www.hackerrank.com/challenges/making-anagrams/problem
fun makingAnagrams(s1: String, s2: String): Int {
    var result = 0
    val map = s1.groupingBy { it }.eachCount().toMutableMap()

    s2.forEach {
        val count = map.getOrDefault(it, 0)
        if (count == 0) {
            result++
        } else {
            map[it] = count - 1
        }
    }
    return result + map.values.reduce { acc, i -> acc + i }

}