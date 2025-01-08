package lit.ds

class Node<T>(
    var value: T,
    var next: Node<T>? = null
)

class MyLinkedList<T> {
    private var head: Node<T>? = null

    fun addFirst(value: T) {
        head = Node(value, head)
    }

    fun addEnd(value: T) {
        if (head == null) {
            addFirst(value)
            return
        }
        var cur = head
        while (cur?.next != null) {
            cur = cur.next
        }
        cur?.next = Node(value)
    }

    fun removeFirst(): T? {
        val value = head?.value
        head = head?.next
        return value
    }

    fun removeLast(): T? {
        if (head == null) return null
        if (head?.next == null) return removeFirst()

        var cur = head
        while (cur?.next?.next != null) {
            cur = cur.next
        }
        val value = cur?.next?.value
        cur?.next = null
        return value
    }

    fun getFirst(): T? = head?.value

    // Получение последнего элемента
    fun getLast(): T? {
        var current = head
        while (current?.next != null) {
            current = current.next
        }
        return current?.value
    }


    fun isEmpty(): Boolean = head == null


    override fun toString(): String {
        val result = StringBuilder()
        var current = head
        while (current != null) {
            result.append(current.value)
            if (current.next != null) {
                result.append(" -> ")
            }
            current = current.next
        }
        return result.toString()
    }

}