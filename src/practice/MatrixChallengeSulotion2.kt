package practice

fun main() {
    val input = arrayOf("aaey,rrum,tgmn,ball", "true,all,ball,mur,raeymnl,tall,trum,said")
    val inputAs2dArray: Array<Array<Char>> = Array(4) {
        Array(4) { '\u0000' }
    }

    var index = 0
    input[0].split(",").forEach {
        inputAs2dArray[index] = it.toCharArray().toTypedArray()
        index++
    }
    val isVisited = arrayOf(
        arrayOf(false, false, false, false).toBooleanArray(),
        arrayOf(false, false, false, false).toBooleanArray(),
        arrayOf(false, false, false, false).toBooleanArray(),
        arrayOf(false, false, false, false).toBooleanArray()
    )

    for(x in 0..3){
        for(y in 0..3){
            travers(inputAs2dArray, x, y, "", isVisited, input[1].split(","))

        }
    }



}

fun travers(
    inputAs2dArray: Array<Array<Char>>,
    i: Int,
    j: Int,
    s: String,
    isVisited: Array<BooleanArray>,
    words: List<String>
) {
    isVisited[i][j] = true
    val newWord = s + inputAs2dArray[i][j]
   isWordAndPrint(newWord, words)

    var row = i - 1
    while (row <= i + 1 && row < 4) {
        var column = j - 1
        while (column <= j + 1 && column < 4) {
            if (row >= 0 && column>=0&&isVisited[row][column].not()) {
                travers(inputAs2dArray, row, column, newWord, isVisited, words)
            }
            column++
        }
        row++
    }
    isVisited[i][j] = false
}

fun isWordAndPrint(string: String, words: List<String>): Boolean {
    words.forEach {
        if (string.contentEquals(it)) {
            println(it)
        }
    }
    return false

}