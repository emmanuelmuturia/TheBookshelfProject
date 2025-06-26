package bookshelf.home.source.remote.source

import bookshelf.commons.state.BookshelfResult
import bookshelf.home.source.remote.dto.BooksDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class BookshelfRemoteSourceImplementation(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val httpClient: HttpClient
) : BookshelfRemoteSource {
    override suspend fun getBooks(bookQuery: String): BookshelfResult<List<BooksDTO>> {
        return withContext(context = coroutineDispatcher) {
            try {
                val response = httpClient.get(urlString = "https://www.googleapis.com/books/v1/volumes") {
                    url {
                        parameters.append(name = "q", value = bookQuery)
                    }
                }
                if (response.status == HttpStatusCode.OK) {
                    BookshelfResult.Success(data = response.body())
                } else {
                    BookshelfResult.Error(error = response.status.description)
                }
            } catch (e: Exception) {
                BookshelfResult.Error(error = e.message ?: "Unknown Error...")
            }
        }
    }
}