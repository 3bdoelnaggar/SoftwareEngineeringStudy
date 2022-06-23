package practice

/*
problems
    2-https://www.hackerrank.com/challenges/organizing-containers-of-balls
    1-https://www.hackerrank.com/challenges/chocolate-feast
 */


fun main(args: Array<String>) {
    println(chocolateFeast(6 ,2, 2))
}


fun chocolateFeast(n: Int, c: Int, m: Int): Int {
    val whatHeCanAfford = n / c
    var emptyWrappers = whatHeCanAfford
    var barEatten :Int= whatHeCanAfford

    while (emptyWrappers >= m) {
        val newBars=emptyWrappers/m
        barEatten+=newBars
        emptyWrappers-=emptyWrappers-(emptyWrappers%m)
        emptyWrappers+=newBars

    }



    return barEatten
}


//fun organizingContainers(container: Array<Array<Int>>): String {
//    val containers=container.size
//    for(x in container){
//
//    }
//}
