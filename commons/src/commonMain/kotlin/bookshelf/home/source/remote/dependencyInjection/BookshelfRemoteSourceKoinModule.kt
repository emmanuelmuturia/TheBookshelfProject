package bookshelf.home.source.remote.dependencyInjection

import bookshelf.home.source.remote.source.BookshelfRemoteSource
import bookshelf.home.source.remote.source.BookshelfRemoteSourceImplementation
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val bookshelfRemoteSourceKoinModule =
    module {
        single {
            HttpClient {
                install(plugin = ContentNegotiation) {
                    json(
                        json = Json {
                            prettyPrint = true
                            isLenient = true
                            ignoreUnknownKeys = true
                        }
                    )
                }
            }
        }

        singleOf(::BookshelfRemoteSourceImplementation).bind(clazz = BookshelfRemoteSource::class)
    }