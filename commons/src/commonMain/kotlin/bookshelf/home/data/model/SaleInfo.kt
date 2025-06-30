package bookshelf.home.data.model

import bookshelf.home.source.local.entity.SaleInfoEntity

data class SaleInfo(
    val buyLink: String? = null,
    val country: String? = null,
    val isEbook: Boolean? = null,
    val saleability: String? = null,
)

fun SaleInfoEntity.toSaleInfo(): SaleInfo {
    return SaleInfo(
        buyLink = buyLink,
        country = country,
        isEbook = isEbook,
        saleability = saleability,
    )
}