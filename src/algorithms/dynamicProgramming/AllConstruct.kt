package algorithms.dynamicProgramming

/*
    Write a function ‘allConstruct(target, wordBank)' that accepts a target string and an array of strings.
    The function should return a 2D_array containing all of the ways that the ‘target" can be constructed by concatenating elements of the wordBank” array.
    Each element of the 2D array should represent one combination that constructs the 'target'.

    You may reuse elements of ‘wordBank' as many times as needed.
*/

fun main() {
    println(allConstruct("purple", arrayOf("purb", "p", "ur", "le", "pur", "ple")))
    //println(allConstruct("abcdef", arrayOf("ab", "abc", "cd", "def", "abcd")))
   // println(allConstruct("skateboard", arrayOf("bo", "rd", "ate", "t", "ska", "sk", "boar")))

    println(
        allConstruct(
            "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
            arrayOf("e", "ee", "eee", "eeee", "eeeee", "eeeeeeee"), hashMapOf()
        )
    )

   println(allConstructTabulation("purple", arrayOf("purb", "p", "ur", "le", "pur", "ple")))

    println(
        allConstructTabulation(
            "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
            arrayOf("e", "ee", "eee", "eeee", "eeeee", "eeeeeeee")
        )
    )
}


fun allConstruct(word: String, wordBank: Array<String>): ArrayList<ArrayList<String>> {

    if (word.isEmpty()) return arrayListOf(arrayListOf())


    val result = ArrayList<ArrayList<String>>()
    for (wordInWordBank in wordBank) {
        if (word.startsWith(wordInWordBank)) {
            val newTarget = word.substring(wordInWordBank.length)
            result += ArrayList(allConstruct(newTarget, wordBank).map {
                it.add(0, wordInWordBank)
                it
            })
        }

    }

    return result


}

fun allConstruct(
    word: String,
    wordBank: Array<String>,
    knowledge: HashMap<String, ArrayList<ArrayList<String>>>
): ArrayList<ArrayList<String>> {


    if (word in knowledge) return knowledge[word] ?: arrayListOf()
    if (word.isEmpty()) return arrayListOf(arrayListOf())


    val result = ArrayList<ArrayList<String>>()
    for (wordInWordBank in wordBank) {
        if (word.startsWith(wordInWordBank)) {
            val newTarget = word.substring(wordInWordBank.length)
            result += ArrayList(allConstruct(newTarget, wordBank, knowledge).map {
                val arrayList = ArrayList(it)
                arrayList.add(0, wordInWordBank)
                arrayList
            })
        }

    }
    knowledge[word] = result

    return result

}

fun allConstructTabulation(word: String, wordBank: Array<String>): List<List<String>> {

    val table = Array<ArrayList<ArrayList<String>>>(word.length.plus(1)) {
        arrayListOf()
    }

    table[0].add(arrayListOf())




    table.forEachIndexed { index, value ->
            wordBank.forEach {string->
                if (word.substring(index).startsWith(string)) {
                  val new =  value.map {
                    val i =  ArrayList<String>(it)
                       i.add(string)
                      i
                    }

                    table[index+string.length].addAll(new)

                }

            }

    }
    return table.last()

}