package lit

import lit.ds.MyLinkedList
import lit.utils.Matth

fun main() {
    val numbers = listOf(1, 2, 4, 5, 6)
    val matth = Matth()



    val min = matth.minn(numbers)
    val max = matth.maxx(numbers)
    val sear = matth.binarySearch(listOf(1,2,5,6), 2)
    println("Min: $min")
    println("Max: $max")
    println(sear)


    val l = MyLinkedList<Int>()
    l.addFirst(12)
    l.addFirst(14)
    println(l)
    println()
}