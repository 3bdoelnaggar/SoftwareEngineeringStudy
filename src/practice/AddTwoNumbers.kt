package practice


fun main() {
    val l1 = ListNode(2).apply {
        next = ListNode(4).apply {
            next = ListNode(3)
        }
    }

    val l2 = ListNode(5).apply {
        next =ListNode(6).apply {
            next=ListNode(4)
        }
    }
    Solution().addTwoNumbers(l1,l2)

}


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var firstNum = 0
        var nextNode = l1
        var e = 0
        while (nextNode != null) {
            firstNum += nextNode.`val` * (Math.pow(10.0, e.toDouble())).toInt()
            nextNode = nextNode.next
            e++
        }

        var secondNum = 0
        nextNode = l2
        e = 0
        while (nextNode != null) {
            secondNum += nextNode.`val` * (Math.pow(10.0, e.toDouble())).toInt()
            nextNode = nextNode.next
            e++
        }

        val sum = firstNum + secondNum

        var head: ListNode? = null
        val sumAsString = sum.toString()

        for (element in sumAsString) {
            val newHead = ListNode(element.toInt())
            newHead.next = head
            head = newHead
        }
        return head

    }
}