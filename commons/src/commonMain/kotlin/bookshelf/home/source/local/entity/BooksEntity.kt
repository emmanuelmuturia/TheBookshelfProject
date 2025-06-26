package bookshelf.home.source.local.entity


import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
data class BooksEntity(
    @ColumnInfo(name = "items")
    val itemEntities: List<ItemEntity>,
    @ColumnInfo(name = "kind")
    val kind: String,
    @ColumnInfo(name = "totalItems")
    val totalItems: Int
)