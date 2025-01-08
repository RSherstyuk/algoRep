package lit.utils  // Исправлено имя пакета

open class Matth {

    fun minn(array: List<Int>): Int {
        if (array.isEmpty()) throw IllegalArgumentException("List is empty")

        var m = array[0]
        for (i in array) {
            if (i < m) {
                m = i
            }
        }
        return m  
    }


    val b = ArrayList<Int>()

    fun maxx(array: List<Int>): Int {
        if (array.isEmpty()) throw IllegalArgumentException("List is empty")

        var m = array[0]
        for (i in array) {
            if (i > m) {
                m = i
            }
        }
        return m  
    }

    fun binarySearch(arr: List<Int>, target: Int): Int {
        var left = 0
        var right = arr.size - 1

        while (left <= right) {
            val mid = left + (right - left) / 2

            when {
                arr[mid] == target -> return mid // Target found
                arr[mid] < target -> left = mid + 1 // Search the right half
                else -> right = mid - 1 // Search the left half
            }
        }

        return -1 // Target not found
    }
}