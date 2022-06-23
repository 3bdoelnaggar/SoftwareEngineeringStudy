package practice

fun pangrams(s: String): String {
      val lowerCase=  s.toLowerCase()
        for(char in 'a'..'z'){
            if(lowerCase.contains(char)){
                continue
            }else{
                return "not pangram"
            }
        }
        return "pangram"
}


fun hackerrankInString(s: String): String {

    val word = "hackerrank"
    var index = word.length-1
      for (charIndex in s.length-1 downTo 0){
          if(s[charIndex]==word[index]){
              index--
          }

   }
    return if(index==-1){
        "YES"
    }else{
        "NO"
    }

}