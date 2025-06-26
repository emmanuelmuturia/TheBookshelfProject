package bookshelf.home.source.local.entity

import kotlinx.serialization.Serializable

@Serializable
data class SaleInfoEntity(
    val buyLink: String,
    val country: String,
    val isEbook: Boolean,
    val saleability: String
)