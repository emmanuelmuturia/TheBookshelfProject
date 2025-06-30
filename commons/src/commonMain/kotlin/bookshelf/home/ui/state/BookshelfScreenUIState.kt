package bookshelf.home.ui.state

import bookshelf.home.data.model.Books

data class BookshelfScreenUIState(
    val books: List<Books> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val bookQuery: String = "Cars"
)