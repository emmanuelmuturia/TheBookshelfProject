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
import bookshelf.home.data.repository.BookshelfRepository
import bookshelf.home.ui.state.BookshelfDetailsScreenUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class BookshelfDetailsScreenViewModel(
    private val bookshelfRepository: BookshelfRepository,
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