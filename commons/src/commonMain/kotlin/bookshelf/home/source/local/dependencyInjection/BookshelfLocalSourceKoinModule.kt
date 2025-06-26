package bookshelf.home.source.local.dependencyInjection

import bookshelf.home.source.local.source.BookshelfLocalSource
import bookshelf.home.source.local.source.BookshelfLocalSourceImplementation
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val bookshelfLocalSourceKoinModule =
    module {
        singleOf(::BookshelfLocalSourceImplementation).bind(clazz = BookshelfLocalSource::class)
    }