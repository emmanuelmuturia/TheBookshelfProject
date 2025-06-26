package bookshelf.home.source.local.source

import bookshelf.home.data.model.Books
import bookshelf.home.source.local.dao.BookshelfDao
import bookshelf.home.source.local.entity.BooksEntity
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
    private val httpClient: HttpClient,
) : BookshelfLocalSource {
    override suspend fun getBooks(bookQuery: String): Flow<List<Books>> {
        return withContext(context = coroutineDispatcher) {
            bookshelfDao.getBooks(bookQuery = bookQuery)
        }.onEach {
            if (it.isEmpty()) {
                fetchRemoteBooks(bookQuery = bookQuery)
            }
        }
    }

    override suspend fun fetchRemoteBooks(bookQuery: String) {
        withContext(context = coroutineDispatcher) {
            val response =
                httpClient.get(urlString = "https://www.googleapis.com/books/v1/volumes") {
                    url {
                        parameters.append(name = "q", value = bookQuery)
                    }
                }
            if (response.status == HttpStatusCode.OK) {
                response.body<List<Books>>().map {
                    bookshelfDao.insertBook(
                        book =
                            BooksEntity(
                                itemEntities = it.items,
                                kind = it.kind,
                                totalItems = it.totalItems,
                            ),
                    )
                }
            }
        }
    }
}