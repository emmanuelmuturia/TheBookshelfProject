package bookshelf.home.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import bookshelf.home.source.local.dao.BookshelfDao
import bookshelf.home.source.local.entity.BooksEntity
import bookshelf.home.source.local.typeConverter.BookshelfTypeConverters

@Database(
    entities = [BooksEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(value = [BookshelfTypeConverters::class])
abstract class BookshelfDatabase : RoomDatabase() {
    abstract fun bookshelfDao(): BookshelfDao
}