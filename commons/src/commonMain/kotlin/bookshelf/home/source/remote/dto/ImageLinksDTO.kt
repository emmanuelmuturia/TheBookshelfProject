package bookshelf.home.source.remote.dto

import bookshelf.home.source.local.entity.ImageLinksEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImageLinksDTO(
    @SerialName("smallThumbnail")
    val smallThumbnail: String? = null,
    @SerialName("thumbnail")
    val thumbnail: String? = null,
) {
    fun toImageLinksEntity(): ImageLinksEntity {
        return ImageLinksEntity(
            smallThumbnail = smallThumbnail?.replace(oldValue = "http", newValue = "https"),
            thumbnail = thumbnail?.replace(oldValue = "http", newValue = "https"),
        )
    }
}