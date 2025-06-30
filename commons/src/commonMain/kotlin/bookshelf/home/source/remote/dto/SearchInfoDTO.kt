package bookshelf.home.source.remote.dto

import bookshelf.home.source.local.entity.SearchInfoEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchInfoDTO(
    @SerialName("textSnippet")
    val textSnippet: String? = null,
) {
    fun toSearchInfoEntity(): SearchInfoEntity {
        return SearchInfoEntity(
            textSnippet = textSnippet,
        )
    }
}