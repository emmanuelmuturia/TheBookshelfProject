package bookshelf.home.source.local.entity

import kotlinx.serialization.Serializable

@Serializable
data class ImageLinksEntity(
    val smallThumbnail: String? = null,
    val thumbnail: String? = null,
)