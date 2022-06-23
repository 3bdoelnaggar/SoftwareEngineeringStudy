package designPatterns.strategy

class Repository constructor(
    private val remoteDataSource: IRemoteDataSource,
    private val localDataSource: ILocalDataSource
) {
    fun getAll(): List<Any?> {
        val data = remoteDataSource.fetch()
        localDataSource.cache(data)
        return localDataSource.getAll()
    }

}

interface ILocalDataSource {
    fun cache(data: List<Any>)
    fun getAll(): List<Any>
}

interface IRemoteDataSource {
    fun fetch(): List<Any>
}

class DummyLocalDataSource : ILocalDataSource {
    override fun cache(data: List<Any>) {
        //save data to your local storage
    }
    override fun getAll(): List<String> {
        //read your cached data
        return arrayListOf()
    }
}
class DummyRemoteDataSource: IRemoteDataSource {
    override fun fetch(): List<Any> {
        //call your remote data source and get some data
        return arrayListOf()
    }
}

fun main(){
    val repository =Repository(DummyRemoteDataSource(),DummyLocalDataSource())
    repository.getAll()
}


