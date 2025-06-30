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
    override suspend fun getBooks(bookQuery: String): Flow<List<Books>> {
        return withContext(context = coroutineDispatcher) {
            bookshelfLocalSource.getBooks(bookQquery = bookQuery).map { books ->
                books.map { book ->
                    Books(
                        items = book.itemEntities.map { it.toItem() },
                        kind = book.kind,
                        totalItems = book.totalItems,
                    )
                }
            }
        }
    }
}