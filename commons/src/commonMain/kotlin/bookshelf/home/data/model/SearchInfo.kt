package bookshelf.home.data.model

import bookshelf.home.source.local.entity.SearchInfoEntity

data class SearchInfo(
    val textSnippet: String? = null,
)

fun SearchInfoEntity.toSearchInfo(): SearchInfo {
    return SearchInfo(
        textSnippet = textSnippet,
    )
}