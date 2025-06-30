package bookshelf.home.data.model

import bookshelf.home.source.local.entity.ReadingModesEntity

data class ReadingModes(
    val image: Boolean,
    val text: Boolean,
)

fun ReadingModesEntity.toReadingModes(): ReadingModes {
    return ReadingModes(
        image = image,
        text = text,
    )
}