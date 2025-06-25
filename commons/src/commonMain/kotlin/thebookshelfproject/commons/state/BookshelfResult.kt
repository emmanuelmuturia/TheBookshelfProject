package thebookshelfproject.commons.state

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

sealed class BookshelfResult<out T> {
    data class Success<out T>(val data: T) : BookshelfResult<T>()

    data class Error(val error: String) : BookshelfResult<Nothing>()
}

fun <T> Flow<T>.asResult(): Flow<BookshelfResult<T>> {
    return this.map<T, BookshelfResult<T>> {
        BookshelfResult.Success(data = it)
    }.catch {
        emit(value = BookshelfResult.Error(error = it.message.toString()))
    }
}