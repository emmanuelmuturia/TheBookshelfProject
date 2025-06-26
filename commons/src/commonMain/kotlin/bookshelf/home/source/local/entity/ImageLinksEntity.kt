package bookshelf.home.source.local.entity

import kotlinx.serialization.Serializable

@Serializable
data class ImageLinksEntity(
    val smallThumbnail: String,
    val thumbnail: String
)