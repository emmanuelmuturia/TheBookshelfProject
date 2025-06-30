package bookshelf.home.data.model

import bookshelf.home.source.local.entity.EpubEntity

data class Epub(
    val downloadLink: String,
    val isAvailable: Boolean,
)

fun EpubEntity.toEpub(): Epub {
    return Epub(
        downloadLink = downloadLink,
        isAvailable = isAvailable,
    )
}