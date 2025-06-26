package bookshelf.home.source.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IndustryIdentifierDTO(
    @SerialName("identifier")
    val identifier: String,
    @SerialName("type")
    val type: String,
)