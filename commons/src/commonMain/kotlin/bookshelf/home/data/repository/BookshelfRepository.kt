package bookshelf.home.data.repository

import bookshelf.home.data.model.Books
import kotlinx.coroutines.flow.Flow

interface BookshelfRepository {
    suspend fun getBooks(): Flow<List<Books>>
}