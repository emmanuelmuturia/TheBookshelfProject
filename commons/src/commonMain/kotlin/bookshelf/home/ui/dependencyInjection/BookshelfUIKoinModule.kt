package bookshelf.home.ui.dependencyInjection

import bookshelf.home.data.dependencyInjection.bookshelfDataKoinModule
import bookshelf.home.ui.viewmodel.BookshelfScreenViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val bookshelfUIKoinModule = module {

    viewModelOf(::BookshelfScreenViewModel)

    includes(module = listOf(
        bookshelfDataKoinModule
    ))

}