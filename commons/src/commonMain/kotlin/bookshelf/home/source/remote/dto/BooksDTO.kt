package bookshelf.home.source.remote.dto

import bookshelf.home.source.local.entity.BooksEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BooksDTO(
    @SerialName("items")
    val itemDTOS: List<ItemDTO>? = null,
    @SerialName("kind")
    val kind: String? = null,
    @SerialName("totalItems")
    val totalItems: Int? = null,
) {
    fun toBooksEntity(): BooksEntity {
        return BooksEntity(
            itemEntities = itemDTOS?.map { it.toItemEntity() },
            kind = kind,
            totalItems = totalItems,
        )
    }
}