package bookshelf.home.ui.state

import bookshelf.home.data.model.Books
import bookshelf.home.data.model.Item

data class BookshelfDetailsScreenUIState(
    val book: Item? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
)
