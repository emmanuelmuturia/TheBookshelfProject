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
package bookshelf.home.ui.dependencyInjection

import bookshelf.home.data.dependencyInjection.bookshelfDataKoinModule
import bookshelf.home.ui.viewmodel.BookshelfDetailsScreenViewModel
import bookshelf.home.ui.viewmodel.BookshelfScreenViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

/**
 * This is the project's UI Layer Koin Module...
 */

val bookshelfUIKoinModule =
    module {

        viewModelOf(::BookshelfScreenViewModel)

        viewModelOf(::BookshelfDetailsScreenViewModel)

        includes(
            module =
                listOf(
                    bookshelfDataKoinModule,
                ),
        )
    }