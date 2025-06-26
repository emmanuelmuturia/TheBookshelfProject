package bookshelf.home.source.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BooksDTO(
    @SerialName("items")
    val itemDTOS: List<ItemDTO>,
    @SerialName("kind")
    val kind: String,
    @SerialName("totalItems")
    val totalItems: Int
)