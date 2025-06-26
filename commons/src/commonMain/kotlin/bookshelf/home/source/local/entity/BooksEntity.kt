package bookshelf.home.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BooksEntity")
data class BooksEntity(
    @PrimaryKey(autoGenerate = true)
    val bookshelfId: Int = 0,
    @ColumnInfo(name = "items")
    val itemEntities: List<ItemEntity>,
    @ColumnInfo(name = "kind")
    val kind: String,
    @ColumnInfo(name = "totalItems")
    val totalItems: Int,
)