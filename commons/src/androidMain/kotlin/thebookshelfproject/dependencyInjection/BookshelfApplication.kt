package thebookshelfproject.dependencyInjection

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import thebookshelfproject.commons.dependencyInjection.initKoin

class BookshelfApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger()
            androidContext(androidContext = this@BookshelfApplication)
        }
    }

}