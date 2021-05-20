package practice




fun main() {
    val words = arrayOf("GEEKS", "FOR", "QUIZ", "GO")
    val chars = arrayOf(
        arrayOf('G', 'I', 'Z').toCharArray(),
        arrayOf('U', 'E', 'K').toCharArray(),
        arrayOf('Q', 'S', 'E').toCharArray()
    )
    findWordsUtil(
        chars,
        arrayOf(
            arrayOf(false, false, false).toBooleanArray(),
            arrayOf(false, false, false).toBooleanArray(),
            arrayOf(false, false, false).toBooleanArray()
        ),
        0,
        0,
        ""
    )

}

const val M: Int = 3
const val N: Int = 3
fun findWordsUtil(
    boggle: Array<CharArray>, visited: Array<BooleanArray>, i: Int,
    j: Int, str: String
) {
    // Mark current cell as visited and append current character
    // to str
    var str = str
    visited[i][j] = true
    str += boggle[i][j]

    // If str is present in dictionary, then print it
    if (isWord(str)) println(str)

    // Traverse 8 adjacent cells of boggle[i][j]
    var row = i - 1
    while (row <= i + 1 && row < M) {
        var col = j - 1
        while (col <= j + 1 && col < N) {
            if (row >= 0 && col >= 0 && !visited[row][col]) {
                findWordsUtil(boggle, visited, row, col, str)
            }
            col++
        }
        row++
    }

    // Erase current character from string and mark visited
    // of current cell as false
    visited[i][j] = false
}

fun isWord(str: String): Boolean {
    val dictionary = arrayOf("GEEKS", "FOR", "QUIZ", "GUQ", "EE")
    val n = dictionary.size
    // Linearly search all words
    for (i in 0 until n) if (str == dictionary[i]) return true
    return false
}