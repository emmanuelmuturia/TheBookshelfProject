package bookshelf.home.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bookshelf.home.data.model.Item
import bookshelf.home.data.repository.BookshelfRepository
import bookshelf.home.ui.state.BookshelfDetailsScreenUIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class BookshelfDetailsScreenViewModel(
    private val bookshelfRepository: BookshelfRepository
) : ViewModel() {

    val bookshelfDetailsScreenUIState = MutableStateFlow(value = BookshelfDetailsScreenUIState())

    fun getBookById(bookId: String) {
        bookshelfDetailsScreenUIState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            bookshelfRepository.getBooks().collect { books ->

                val book = books.flatMap { it.items ?: emptyList() }.firstOrNull { it.id == bookId }

                if (book != null) {
                    bookshelfDetailsScreenUIState.update {
                        it.copy(
                            book = book,
                            isLoading = false,
                        )
                    }
                } else {
                    bookshelfDetailsScreenUIState.update {
                        it.copy(
                            error = "Book not found...",
                            isLoading = false,
                        )
                    }
                }

            }
        }
    }

}