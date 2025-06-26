package bookshelf.home.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import bookshelf.home.source.local.entity.BooksEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BookshelfDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook(books: BooksEntity)

    @Query("SELECT * FROM BooksEntity")
    fun getBooks(): Flow<List<BooksEntity>>

}