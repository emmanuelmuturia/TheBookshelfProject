package bookshelf.home.source.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchInfoDTO(
    @SerialName("textSnippet")
    val textSnippet: String
)