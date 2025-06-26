package bookshelf.dependencyInjection

import bookshelf.home.local.source.database.getBookshelfDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val bookshelfAndroidKoinModule =
    module {
        single {
            getBookshelfDatabase(context = androidContext()).bookshelfDao()
        }
    }