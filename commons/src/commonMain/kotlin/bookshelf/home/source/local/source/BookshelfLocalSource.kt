package bookshelf.home.source.local.source

import bookshelf.home.source.local.entity.BooksEntity
import kotlinx.coroutines.flow.Flow

interface BookshelfLocalSource {
    suspend fun getBooks(): Flow<List<BooksEntity>>

    suspend fun fetchRemoteBooks()
}