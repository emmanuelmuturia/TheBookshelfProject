package bookshelf.home.source.remote.dto

import bookshelf.home.source.local.entity.EpubEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EpubDTO(
    @SerialName("downloadLink")
    val downloadLink: String? = null,
    @SerialName("isAvailable")
    val isAvailable: Boolean? = null,
) {
    fun toEpubEntity(): EpubEntity {
        return EpubEntity(
            downloadLink = downloadLink,
            isAvailable = isAvailable,
        )
    }
}