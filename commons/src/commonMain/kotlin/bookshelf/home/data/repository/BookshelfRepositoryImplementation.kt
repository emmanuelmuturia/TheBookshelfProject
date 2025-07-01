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
package bookshelf.home.data.repository

import bookshelf.home.data.model.Books
import bookshelf.home.data.model.toItem
import bookshelf.home.source.local.source.BookshelfLocalSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class BookshelfRepositoryImplementation(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val bookshelfLocalSource: BookshelfLocalSource,
) : BookshelfRepository {
    override suspend fun getBooks(): Flow<List<Books>> {
        return withContext(context = coroutineDispatcher) {
            bookshelfLocalSource.getBooks().map { books ->
                books.map { book ->
                    Books(
                        items = book.itemEntities?.map { it.toItem() },
                        kind = book.kind,
                        totalItems = book.totalItems,
                    )
                }
            }
        }
    }

    override suspend fun searchBook(bookQuery: String) {
        return withContext(context = coroutineDispatcher) {
            bookshelfLocalSource.searchBooks(bookQuery = bookQuery)
        }
    }
}