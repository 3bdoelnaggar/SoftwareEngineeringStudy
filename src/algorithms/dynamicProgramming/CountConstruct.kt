package algorithms.dynamicProgramming

fun main() {


    println(countConstruct("purple", arrayOf("purb", "p", "ur", "le", "purple")))
    println(countConstruct("abcdef", arrayOf("ab", "abc", "cd", "def", "abcd")))
    println(countConstruct("skateboard", arrayOf("bo", "rd", "ate", "t", "ska", "sk", "boar")))

    println(
        countConstruct(
            "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
            arrayOf("e", "ee", "eee", "eeee", "eeeee", "eeeeeeee"), hashMapOf()
        )
    )


}

fun countConstruct(word: String, wordBank: Array<String>): Int {
    if (word.isEmpty()) return 1

    var count = 0
    for (s in wordBank) {
        if (word.startsWith(s)) {
            val newWord = word.substring(s.length, word.length)
            count += countConstruct(newWord, wordBank)
        }
    }
    return count
}

fun countConstruct(word: String, wordBank: Array<String>, knowledge: HashMap<String, Int>): Int {
    if (word in knowledge) return knowledge[word] ?: 0
    if (word.isEmpty()) return 1

    var count = 0
    for (s in wordBank) {
        if (word.startsWith(s)) {
            val newWord = word.substring(s.length)
            count += countConstruct(newWord, wordBank, knowledge)
        }
    }
    knowledge[word] = count
    return count
}