package bookshelf.home.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Bookshelf")
data class BooksEntity(
    @PrimaryKey(autoGenerate = true)
    val bookshelfId: Int = 0,
    @ColumnInfo(name = "items")
    val itemEntities: List<ItemEntity>? = null,
    @ColumnInfo(name = "kind")
    val kind: String? = null,
    @ColumnInfo(name = "totalItems")
    val totalItems: Int? = null,
)