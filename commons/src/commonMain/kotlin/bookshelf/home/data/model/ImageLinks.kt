package bookshelf.home.data.model

import bookshelf.home.source.local.entity.ImageLinksEntity

data class ImageLinks(
    val smallThumbnail: String? = null,
    val thumbnail: String? = null,
)

fun ImageLinksEntity.toImageLinks(): ImageLinks {
    return ImageLinks(
        smallThumbnail = smallThumbnail?.replace(oldValue = "http", newValue = "https"),
        thumbnail = thumbnail?.replace(oldValue = "http", newValue = "https"),
    )
}