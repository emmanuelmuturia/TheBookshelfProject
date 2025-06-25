/*
 * Copyright 2025 The Bookshelf Project
 *
 * Licenced under the Apache License, Version 2.0 (the "Licence");
 * you may not use this file except in compliance with the Licence.
 * You may obtain a copy of the Licence at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 */
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