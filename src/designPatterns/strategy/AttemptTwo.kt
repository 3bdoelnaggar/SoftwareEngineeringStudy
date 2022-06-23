package designPatterns.strategy

interface IFetchBehavior {
    fun fetch(): List<Any>
}

class FetchWithThrowBehavior : IFetchBehavior {
    override fun fetch(): List<Any> {
        val result = callApi()
        if (result.isEmpty()) {
            throw Exception()
        }
        return listOf()
    }

    private fun callApi(): List<Any> {
        return listOf()
    }
}

class FetchWithoutThrowBehavior : IFetchBehavior {
    override fun fetch(): List<Any> {
        val result = callApi()
        return result
    }

    private fun callApi(): List<Any> {
        return listOf()
    }
}

class RemoteDataSource(private val fetchBehavior: IFetchBehavior) {
    fun loadData(): List<Any> {
        return fetchBehavior.fetch()
    }
}

fun main() {
    RemoteDataSource(FetchWithThrowBehavior()).loadData()
    RemoteDataSource(FetchWithoutThrowBehavior()).loadData()
}