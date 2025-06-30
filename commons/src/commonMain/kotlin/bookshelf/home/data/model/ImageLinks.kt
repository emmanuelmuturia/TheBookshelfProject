package bookshelf.home.data.model

import bookshelf.home.source.local.entity.ImageLinksEntity

data class ImageLinks(
    val smallThumbnail: String,
    val thumbnail: String,
)

fun ImageLinksEntity.toImageLinks(): ImageLinks {
    return ImageLinks(
        smallThumbnail = smallThumbnail,
        thumbnail = thumbnail,
    )
}