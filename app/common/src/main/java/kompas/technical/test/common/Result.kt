package kompas.technical.test.common

//sealed class DataResult<out T>(val value: T? = null, val throwable: Throwable? = null) {
//    class Success<T>(data: T) : DataResult<T>(data)
//    class Failure<T>(throwable: Throwable?) : DataResult<T>(throwable = throwable)
//}

sealed class DataResult<out T>(val value: T? = null, val message: String? = null) {
    class Success<T>(data: T) : DataResult<T>(data)
    class Failure<T>(message: String, data:T? = null) : DataResult<T>(data, message)
    class Loading<T>: DataResult<T>()
}