package practice

/*
1-https://www.hackerrank.com/challenges/lisa-workbook/problem
 */

fun main() {
    println(workbook(5, 3, arrayOf(4, 2, 6, 1, 10)))

}

fun workbook(n: Int, k: Int, arr: Array<Int>): Int {
    var page = 1
    var spicial = 0
    var isPageFlipped=false

    for (element in arr) {
        println("chapter  page:$page  spicial:$spicial")
        var problemOnPage = 0
        for (indexInChapter in 1..element) {
            problemOnPage++
            println("problem  problemOnPage:$problemOnPage  page:$page")

            if (page == indexInChapter) {
                spicial++
            }
            if (problemOnPage == k) {
                page++
                problemOnPage = 0
                isPageFlipped=true
            }else{
                isPageFlipped=false
            }
        }
        if(isPageFlipped.not()) {
            page++
        }
    }

    return spicial

}