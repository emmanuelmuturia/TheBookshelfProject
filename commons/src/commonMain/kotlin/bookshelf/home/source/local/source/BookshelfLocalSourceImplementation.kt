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
package bookshelf.home.source.local.source

import bookshelf.commons.state.BookshelfResult
import bookshelf.home.source.local.dao.BookshelfDao
import bookshelf.home.source.local.entity.BooksEntity
import bookshelf.home.source.remote.dto.BooksDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.withContext

/**
 * This is the Home feature's Local Data Source Implementation...
 */

class BookshelfLocalSourceImplementation(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val bookshelfDao: BookshelfDao,
    private val httpClient: HttpClient,
) : BookshelfLocalSource {
    override suspend fun getBooks(): Flow<List<BooksEntity>> {
        return withContext(context = coroutineDispatcher) {
            bookshelfDao.getBooks()
        }.onEach {
            if (it.isEmpty()) {
                fetchRemoteBooks()
            }
        }
    }

    override suspend fun fetchRemoteBooks() {
        withContext(context = coroutineDispatcher) {
            val response =
                httpClient.get(urlString = "https://www.googleapis.com/books/v1/volumes") {
                    url {
                        parameters.append(name = "q", value = "cars")
                    }
                }
            if (response.status == HttpStatusCode.OK) {
                bookshelfDao.insertBook(book = response.body<BooksDTO>().toBooksEntity())
            } else {
                BookshelfResult.Error(error = response.status.description)
            }
        }
    }

    override suspend fun searchBooks(bookQuery: String) {
        withContext(context = coroutineDispatcher) {
            val response =
                httpClient.get(urlString = "https://www.googleapis.com/books/v1/volumes") {
                    url {
                        parameters.append(name = "q", value = bookQuery)
                    }
                }
            if (response.status == HttpStatusCode.OK) {
                bookshelfDao.deleteBooks()
                bookshelfDao.insertBook(book = response.body<BooksDTO>().toBooksEntity())
            } else {
                BookshelfResult.Error(error = response.status.description)
            }
        }
    }
}