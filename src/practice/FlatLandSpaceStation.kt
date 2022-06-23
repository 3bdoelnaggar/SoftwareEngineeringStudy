package practice



fun main(){
   print(flatlandSpaceStations(20,arrayOf( 1,6, 11,10,13)))
}
//https://www.hackerrank.com/challenges/flatland-space-stations/problem
fun flatlandSpaceStations(n: Int, c: Array<Int>): Int {
val sortedArray = c.sortedArray()
    val fromFirstStation = sortedArray[0]
    val fromLastStation = -sortedArray[sortedArray.size-1]+(n-1)
    var max = maxOf(fromLastStation,fromFirstStation)

    for(x in 0..sortedArray.size-2){
        val diff = (sortedArray[x+1]-sortedArray[x])/2
        if(diff>max){
            max=diff
        }
    }
    return max


}