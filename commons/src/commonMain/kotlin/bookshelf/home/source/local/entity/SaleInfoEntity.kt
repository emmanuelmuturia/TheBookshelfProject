package bookshelf.home.source.local.entity

import kotlinx.serialization.Serializable

@Serializable
data class SaleInfoEntity(
    val buyLink: String? = null,
    val country: String? = null,
    val isEbook: Boolean? = null,
    val saleability: String? = null,
)