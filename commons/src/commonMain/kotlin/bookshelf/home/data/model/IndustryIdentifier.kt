package bookshelf.home.data.model

import bookshelf.home.source.local.entity.IndustryIdentifierEntity

data class IndustryIdentifier(
    val identifier: String? = null,
    val type: String? = null,
)

fun IndustryIdentifierEntity.toIndustryIdentifier(): IndustryIdentifier {
    return IndustryIdentifier(
        identifier = identifier,
        type = type,
    )
}