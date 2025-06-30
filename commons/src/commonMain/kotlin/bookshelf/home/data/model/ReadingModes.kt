package bookshelf.home.data.model

import bookshelf.home.source.local.entity.ReadingModesEntity

data class ReadingModes(
    val image: Boolean? = null,
    val text: Boolean? = null,
)

fun ReadingModesEntity.toReadingModes(): ReadingModes {
    return ReadingModes(
        image = image,
        text = text,
    )
}