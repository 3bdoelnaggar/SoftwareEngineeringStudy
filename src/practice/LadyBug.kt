package practice

fun happyLadybugs(b: String): String {
    // Write your code here
    var stringInState = b
    val underScore = "_"
    val mapOf = HashMap<Char, ArrayList<Int>>()
    b.forEachIndexed { index, char ->
        val indexes = mapOf[char]
        if (indexes != null) {
            //mapOf[char] = indexes.add(index)
        } else {
            val indexes = ArrayList<Int>()
            indexes.add(index)
            mapOf[char] = indexes
        }
    }
    fun isHappy(): Boolean {
        mapOf.values.forEach {
            if (it.size < 2) {
                return false
            } else {
                for (i in 0..it.size - 1) {
                    for (z in 1..it.size - 1) {
                        if (it[i] == it[z]) {
                            return true
                        }
                    }
                }
                return false
            }
        }
        return false
    }
    if (isHappy()) {
        return "YES"
    } else {
        mapOf.values.forEach {
            if (it.size < 2) {
                return "NO"
            }
            if (mapOf['_'] == null) {
                return "NO"
            }
            return "YES"
        }
    }

    return "NO"
}