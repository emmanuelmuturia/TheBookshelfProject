package bookshelf.home.source.remote.dto

import bookshelf.home.source.local.entity.IndustryIdentifierEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IndustryIdentifierDTO(
    @SerialName("identifier")
    val identifier: String? = null,
    @SerialName("type")
    val type: String? = null,
) {
    fun toIndustryIdentifierEntity(): IndustryIdentifierEntity {
        return IndustryIdentifierEntity(
            identifier = identifier,
            type = type,
        )
    }
}