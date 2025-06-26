package bookshelf.home.source.remote.dependencyInjection

import bookshelf.home.source.remote.source.BookshelfRemoteSource
import bookshelf.home.source.remote.source.BookshelfRemoteSourceImplementation
import io.ktor.client.HttpClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val bookshelfRemoteSourceKoinModule =
    module {
        single {
            HttpClient()
        }

        singleOf(::BookshelfRemoteSourceImplementation).bind(clazz = BookshelfRemoteSource::class)
    }