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
package bookshelf.home.data.dependencyInjection

import bookshelf.home.data.repository.BookshelfRepository
import bookshelf.home.data.repository.BookshelfRepositoryImplementation
import bookshelf.home.source.local.dependencyInjection.bookshelfLocalSourceKoinModule
import bookshelf.home.source.remote.dependencyInjection.bookshelfRemoteSourceKoinModule
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val bookshelfDataKoinModule =
    module {

        singleOf(::BookshelfRepositoryImplementation).bind(clazz = BookshelfRepository::class)

        includes(
            module =
                listOf(
                    bookshelfLocalSourceKoinModule,
                    bookshelfRemoteSourceKoinModule,
                ),
        )
    }