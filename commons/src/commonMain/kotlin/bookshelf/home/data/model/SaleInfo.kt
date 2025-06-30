package bookshelf.home.data.model

import bookshelf.home.source.local.entity.SaleInfoEntity

data class SaleInfo(
    val buyLink: String,
    val country: String,
    val isEbook: Boolean,
    val saleability: String,
)

fun SaleInfoEntity.toSaleInfo(): SaleInfo {
    return SaleInfo(
        buyLink = buyLink,
        country = country,
        isEbook = isEbook,
        saleability = saleability,
    )
}