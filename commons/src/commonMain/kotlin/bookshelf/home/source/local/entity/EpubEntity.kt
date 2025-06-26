package bookshelf.home.source.local.entity

import kotlinx.serialization.Serializable

@Serializable
data class EpubEntity(
    val downloadLink: String,
    val isAvailable: Boolean,
)