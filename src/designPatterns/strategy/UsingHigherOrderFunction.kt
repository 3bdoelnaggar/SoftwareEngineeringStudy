package designPatterns.strategy

val fetchWithThrowBehavior: () -> List<Any> = {
    val result = callApi()
    if (result.isEmpty()) {
        throw Exception()
    }
    listOf()
}


val fetchWithoutThrowBehavior: () -> List<Any> = {
    val result = callApi()
    result
}

private fun callApi(): List<Any> {
    return listOf()
}


class RemoteSource(private val fetchBehavior: () -> List<Any>) {
    fun loadData(): List<Any> {
        return fetchBehavior.invoke()
    }
}

fun main() {
    RemoteSource(fetchWithoutThrowBehavior).loadData()
    RemoteSource(fetchWithThrowBehavior).loadData()
}