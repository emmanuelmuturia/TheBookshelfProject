package bookshelf.home.ui.state

import bookshelf.home.data.model.Books

data class BookshelfScreenUIState(
    val books: List<Books> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val bookQuery: String = "Cars"
)