package bookshelf.home.source.local.entity

import kotlinx.serialization.Serializable

@Serializable
data class IndustryIdentifierEntity(
    val identifier: String? = null,
    val type: String? = null,
)