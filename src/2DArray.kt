import java.util.*

fun twoDArrayRunner() {

    val dArrayString = "1 1 1 0 0 0\n0 1 0 0 0 0\n1 1 1 0 0 0\n0 0 2 4 4 0\n0 0 0 2 0 0\n0 0 1 2 4 0"


    val twoDArray = Array(6) { Array(6) { 0 } }
    //fill Array from string
    val lines = dArrayString.split("\n")
    lines.forEachIndexed { index, value ->
        twoDArray[index] = value.split(" ").map {
            it.trim().toInt()
        }.toTypedArray()
    }

    print(twoDArray.contentDeepToString())
    val points = listOf(
            Pair(0, 0),
            Pair(0, 1),
            Pair(0, 2),
            Pair(0, 3),
            Pair(1, 0),
            Pair(1, 1),
            Pair(1, 2),
            Pair(1, 3),
            Pair(2, 0),
            Pair(2, 1),
            Pair(2, 2),
            Pair(2, 3),
            Pair(3, 0),
            Pair(3, 1),
            Pair(3, 2),
            Pair(3, 3)
    )
    var biggerSum = Int.MIN_VALUE

    var x = 0
    var y = 0

    repeat(16) {
        var sum: Int = twoDArray[x][y] + twoDArray[x][y + 1] + twoDArray[x][y + 2]//fist raw
        sum += twoDArray[x + 1][y + 1] //second raw
        sum += twoDArray[x + 2][y] + twoDArray[x + 2][y + 1] + twoDArray[x + 2][y + 2]
        if (sum > biggerSum) biggerSum = sum

        if (y == 3) {
            x++
            y = 0
        } else {
            y++
        }
    }

    print(biggerSum)


}