package bookshelf.commons.dependencyInjection

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.dsl.module

val commonsKoinModule = module {

    single {
        Dispatchers.IO
    }

}