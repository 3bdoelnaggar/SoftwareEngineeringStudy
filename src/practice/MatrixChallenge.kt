package practice

fun main(args: Array<String>) {
    matrixChallenge(arrayOf("aaey,rrum,tgmn,ball", "all,ball,mur,raeymnl,tall,true,trum"))
}

fun matrixChallenge(arrayOf: Array<String>) {
    val chars = ArrayList<Char>()
    arrayOf[0].split(",").forEach {
        chars.addAll(it.toCharArray().toList())
    }
    println(chars)

}
