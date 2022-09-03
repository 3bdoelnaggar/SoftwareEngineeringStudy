package algorithms.dynamicProgramming

/**
 * write function canConstruct(target, wordBank) that accept a target a string and array of strings
 * the function should return a boolean  indication whether or not the target can be constructed by the array of strings
 */
fun main() {
    println(canConstruct("abcdef", arrayOf("ab", "abc", "cd", "def", "abcd")))
    println(canConstruct("skateboard", arrayOf("bo", "rd", "ate", "t", "ska", "sk", "boar")))

    println(canConstructTabulation("abcdef", arrayOf("ab", "abc", "cd", "def", "abcd")))
    println(canConstructTabulation("skateboard", arrayOf("bo", "rd", "ate", "t", "ska", "sk", "boar")))

    println(
        canConstruct(
            "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
            arrayOf("e", "ee", "eee", "eeee", "eeeee", "eeeeeeee"), HashMap()
        )
    )


}


fun canConstruct(word: String, wordBank: Array<String>): Boolean {
    if (word.isEmpty()) return true
    wordBank.forEach {
        if (word.startsWith(it)) {
            val substring = word.substring(it.length, word.length)
            val result = canConstruct(substring, wordBank)
            if (result) {
                return true
            }
        }
    }
    return false


}


fun canConstruct(word: String, wordBank: Array<String>, knowledge: HashMap<String, Boolean>): Boolean {
    if (word in knowledge) return knowledge[word]!!
    if (word.isEmpty()) return true
    wordBank.forEach {
        if (word.startsWith(it)) {
            val substring = word.substring(it.length, word.length)
            val result = canConstruct(substring, wordBank, knowledge)
            if (result) {
                knowledge[word] = result
                return true
            }
        }
    }
    knowledge[word] = false
    return false


}

fun canConstructTabulation(word: String, wordBank: Array<String>): Boolean {
    val table = Array(word.length+1){
        false
    }
    table[0] = true

    table.forEachIndexed { index, b ->
        if (b) {
            wordBank.forEach {
                if (word.substring(index).startsWith(it)) {
                    if(index+it.length<table.size) {
                        table[index + it.length] = true
                    }
                }

            }
        }
    }
    return table.last()
}