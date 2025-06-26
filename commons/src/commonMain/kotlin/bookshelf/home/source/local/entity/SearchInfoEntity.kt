package bookshelf.home.source.local.entity

import kotlinx.serialization.Serializable

@Serializable
data class SearchInfoEntity(
    val textSnippet: String,
)