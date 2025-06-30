package bookshelf.home.source.local.source

import bookshelf.commons.state.BookshelfResult
import bookshelf.home.source.local.dao.BookshelfDao
import bookshelf.home.source.local.entity.BooksEntity
import bookshelf.home.source.remote.dto.BooksDTO
import bookshelf.home.source.remote.source.BookshelfRemoteSource
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.withContext

class BookshelfLocalSourceImplementation(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val bookshelfDao: BookshelfDao,
    private val httpClient: HttpClient
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
}