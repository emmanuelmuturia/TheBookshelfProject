package bookshelf.home.data.repository

import bookshelf.home.source.local.source.BookshelfLocalSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class BookshelfRepositoryImplementation(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val bookshelfLocalSource: BookshelfLocalSource
): BookshelfRepository {
    override suspend fun getBooks(bookQuery: String) {
        withContext(context = coroutineDispatcher) {
            bookshelfLocalSource.getBooks(bookQquery = bookQuery)
        }
    }
}