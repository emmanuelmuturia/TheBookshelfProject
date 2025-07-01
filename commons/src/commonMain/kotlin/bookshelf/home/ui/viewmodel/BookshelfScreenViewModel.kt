/*
 * Copyright 2025 The Bookshelf Project
 *
 * Licenced under the Apache License, Version 2.0 (the "Licence");
 * you may not use this file except in compliance with the Licence.
 * You may obtain a copy of the Licence at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 */
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

/**
 * This is the Home feature's Home Screen [ViewModel]...
 */

class BookshelfScreenViewModel(
    private val bookshelfRepository: BookshelfRepository,
) : ViewModel() {
    val bookshelfScreenUIState = MutableStateFlow(value = BookshelfScreenUIState())

    init {
        getBooks()
    }

    fun getBooks() {
        bookshelfScreenUIState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            bookshelfRepository.getBooks().asResult().collect { result ->

                when (result) {
                    is BookshelfResult.Success -> {
                        bookshelfScreenUIState.update {
                            it.copy(
                                books = result.data,
                                isLoading = false,
                            )
                        }
                    }

                    is BookshelfResult.Error -> {
                        bookshelfScreenUIState.update {
                            it.copy(
                                error = result.error,
                                isLoading = false,
                            )
                        }
                    }
                }
            }
        }
    }

    fun searchBooks(bookQuery: String) {
        viewModelScope.launch {
            bookshelfScreenUIState.update { it.copy(isLoading = true) }

            val result =
                runCatching {
                    bookshelfRepository.searchBook(bookQuery = bookQuery)
                }

            result.onSuccess {
                getBooks()
            }.onFailure { throwable ->
                bookshelfScreenUIState.update {
                    it.copy(error = throwable.message ?: "Unknown Error...", isLoading = false)
                }
            }
        }
    }
}