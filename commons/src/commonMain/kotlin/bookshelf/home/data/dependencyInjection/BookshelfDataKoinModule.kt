package bookshelf.home.data.dependencyInjection

import bookshelf.home.data.repository.BookshelfRepository
import bookshelf.home.data.repository.BookshelfRepositoryImplementation
import bookshelf.home.source.local.dependencyInjection.bookshelfLocalSourceKoinModule
import bookshelf.home.source.remote.dependencyInjection.bookshelfRemoteSourceKoinModule
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val bookshelfDataKoinModule = module {

    singleOf(::BookshelfRepositoryImplementation).bind(clazz = BookshelfRepository::class)

    includes(module = listOf(
        bookshelfLocalSourceKoinModule,
        bookshelfRemoteSourceKoinModule
    ))

}