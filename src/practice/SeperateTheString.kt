package practice

fun main(){
    separateNumbers("11111111111111111111111111111111")
}

fun separateNumbers(s: String) {
    if (s[0] == '0') {
        println("NO")
        return
    }
    var step = 1
    var start = s.substring(0,step).toLong()
    var nextNum = start+1
    var substring = s.substring(step)
    while (true){
        if(substring.startsWith(nextNum.toString())){
            substring= substring.substring(nextNum.toString().length)
            if(substring.isEmpty()){
                println("YES $start")
                return
            }else{
                nextNum += 1
            }
        }else{
            step++
            if(step>(s.length/2)){
                println("NO")
                return
            }
            start = s.substring(0,step).toLong()
            nextNum =start+1
            substring = s.substring(step)
        }
    }
}