package practice

/*problems
1-https://www.hackerrank.com/challenges/cavity-map/problem
2-
 */
fun main() {

}

// Complete the cavityMap function below.
fun cavityMap(grid: Array<String>): Array<String> {
    val numberGrid = Array(grid.size) { index ->
        val list = grid[index].toCharArray().map {
            it.toInt()
        }
        list.toTypedArray()
    }
    for (rawIndex in 1 until numberGrid.size - 1) {
        for (columnIndex in 1 until numberGrid[rawIndex].size - 1) {
            val current = numberGrid[rawIndex][columnIndex]
            val left = numberGrid[rawIndex - 1][columnIndex]
            val right = numberGrid[rawIndex + 1][columnIndex]
            val top = numberGrid[rawIndex][columnIndex - 1]
            val bottom = numberGrid[rawIndex][columnIndex + 1]

            if (current > left && current > right && current > top && current > bottom) {
                val toCharArray = grid[rawIndex].toCharArray()
                toCharArray[columnIndex] = 'X'
                grid[rawIndex] = String(toCharArray)
            }
        }
    }
    return grid
}


/*
1 2 3 4 5 6
2 3 4 5 6 7
5 6 7 8 7 3
2 4 5 6 7 8
 */