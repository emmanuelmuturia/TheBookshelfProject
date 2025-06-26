package bookshelf.home.local.source.database

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import bookshelf.home.source.local.database.BookshelfDatabase

fun getBookshelfDatabase(context: Context): BookshelfDatabase {
    val databaseFile = context.getDatabasePath("bookshelfDatabase.db")
    return Room.databaseBuilder<BookshelfDatabase>(
        context = context.applicationContext,
        name = databaseFile.absolutePath
    ).setDriver(driver = BundledSQLiteDriver())
        .build()
}