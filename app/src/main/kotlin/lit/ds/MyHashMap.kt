class MyHashMap<K, V> {
    private val capacity = 16 // Начальная емкость хэш-таблицы
    private val table = Array<MutableList<Entry<K, V>>>(capacity) { mutableListOf() }

    private data class Entry<K, V>(val key: K, var value: V)

    private fun hash(key: K): Int {
        return key.hashCode() % capacity
    }

    fun put(key: K, value: V) {
        val index = hash(key)
        val bucket = table[index]

        for (entry in bucket) {
            if (entry.key == key) {
                entry.value = value // Обновляем значение, если ключ уже существует
                return
            }
        }

        // Если ключ не найден, добавляем новую запись
        bucket.add(Entry(key, value))
    }

    // Получение элемента по ключу
    fun get(key: K): V? {
        val index = hash(key)
        val bucket = table[index]

        // Ищем ключ в bucket
        for (entry in bucket) {
            if (entry.key == key) {
                return entry.value
            }
        }

        // Если ключ не найден, возвращаем null
        return null
    }

    // Удаление элемента по ключу
    fun remove(key: K) {
        val index = hash(key)
        val bucket = table[index]

        // Ищем ключ в bucket и удаляем его
        val iterator = bucket.iterator()
        while (iterator.hasNext()) {
            val entry = iterator.next()
            if (entry.key == key) {
                iterator.remove()
                return
            }
        }
    }

    // Проверка наличия ключа
    fun containsKey(key: K): Boolean {
        return get(key) != null
    }

    // Получение размера HashMap
    fun size(): Int {
        return table.sumOf { it.size }
    }
}
