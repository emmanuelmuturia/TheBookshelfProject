package bookshelf.home.data.model

import bookshelf.home.source.local.entity.IndustryIdentifierEntity

data class IndustryIdentifier(
    val identifier: String,
    val type: String,
)

fun IndustryIdentifierEntity.toIndustryIdentifier(): IndustryIdentifier {
    return IndustryIdentifier(
        identifier = identifier,
        type = type,
    )
}