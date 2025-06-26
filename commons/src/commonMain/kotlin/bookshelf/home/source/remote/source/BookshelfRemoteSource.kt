package bookshelf.home.source.remote.source

import bookshelf.commons.state.BookshelfResult
import bookshelf.home.source.remote.dto.BooksDTO

interface BookshelfRemoteSource {
    suspend fun getBooks(bookQuery: String): BookshelfResult<List<BooksDTO>>
}