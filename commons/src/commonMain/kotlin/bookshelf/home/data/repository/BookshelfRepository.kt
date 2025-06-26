package bookshelf.home.data.repository

interface BookshelfRepository {
    suspend fun getBooks(bookQuery: String)
}