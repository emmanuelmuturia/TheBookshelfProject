package bookshelf.home.source.local.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.room.TypeConverters
import bookshelf.home.source.local.dao.BookshelfDao
import bookshelf.home.source.local.entity.BooksEntity
import bookshelf.home.source.local.typeConverter.BookshelfTypeConverters

@Database(
    entities = [BooksEntity::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(value = [BookshelfTypeConverters::class])
@ConstructedBy(value = BookshelfDatabaseConstructor::class)
abstract class BookshelfDatabase : RoomDatabase() {
    abstract fun bookshelfDao(): BookshelfDao
}

@Suppress(names = ["NO_ACTUAL_FOR_EXPECT"])
expect object BookshelfDatabaseConstructor: RoomDatabaseConstructor<BookshelfDatabase> {
    override fun initialize(): BookshelfDatabase
}