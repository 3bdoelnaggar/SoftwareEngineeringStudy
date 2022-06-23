package practice

import kotlin.math.max

fun minimumNumber(n: Int, password: String): Int {
    val numOfCharsNeededToBeAdded= 6-n

    val listOfChecks= arrayListOf(false,false,false,false)
    val spicialChars = "\"!@#\$%^&*()-+\""

    password.forEach {
        if(it.isLowerCase()){
            listOfChecks[0]=true

        }
        if(it.isUpperCase()){
            listOfChecks[1]=true

        }
        if(it.isDigit()){
            listOfChecks[2]=true


        }
        if(spicialChars.contains(it,true)){
            listOfChecks[3]=true
        }
    }
    var notMatchedChecks = 0
    listOfChecks.forEach {
        if(it.not()){
            notMatchedChecks++
        }
    }
    return max(notMatchedChecks,numOfCharsNeededToBeAdded)

}