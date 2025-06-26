package bookshelf.home.source.local.source

import bookshelf.home.data.model.Books
import kotlinx.coroutines.flow.Flow

interface BookshelfLocalSource {
    suspend fun getBooks(bookQquery: String): Flow<List<Books>>
    suspend fun fetchRemoteBooks(bookQuery: String)
}