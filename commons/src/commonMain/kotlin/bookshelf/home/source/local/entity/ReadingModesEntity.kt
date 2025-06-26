package bookshelf.home.source.local.entity

import kotlinx.serialization.Serializable

@Serializable
data class ReadingModesEntity(
    val image: Boolean,
    val text: Boolean,
)