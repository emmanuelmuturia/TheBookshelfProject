package bookshelf.home.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bookshelf.commons.state.BookshelfResult
import bookshelf.commons.state.asResult
import bookshelf.home.data.repository.BookshelfRepository
import bookshelf.home.ui.state.BookshelfScreenUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class BookshelfScreenViewModel(
    private val bookshelfRepository: BookshelfRepository
) : ViewModel() {

    val bookshelfScreenUIState = MutableStateFlow(value = BookshelfScreenUIState())

    init {
        getBooks(bookQuery = bookshelfScreenUIState.value.bookQuery)
    }

    fun getBooks(bookQuery: String) {
        bookshelfScreenUIState.update { it.copy(isLoading = true) }
        viewModelScope.launch {

            bookshelfRepository.getBooks(bookQuery = bookQuery).asResult().collect { result ->

                when (result) {

                    is BookshelfResult.Success -> {
                        bookshelfScreenUIState.update {
                            it.copy(
                                books = result.data,
                                isLoading = false
                            )
                        }
                    }

                    is BookshelfResult.Error -> {
                        bookshelfScreenUIState.update {
                            it.copy(
                                errorMessage = result.error,
                                isLoading = false
                            )
                        }
                    }

                }

            }

        }
    }

}