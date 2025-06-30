package bookshelf.home.source.remote.dto

import bookshelf.home.source.local.entity.SaleInfoEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SaleInfoDTO(
    @SerialName("buyLink")
    val buyLink: String? = null,
    @SerialName("country")
    val country: String? = null,
    @SerialName("isEbook")
    val isEbook: Boolean? = null,
    @SerialName("saleability")
    val saleability: String? = null,
) {
    fun toSaleInfoEntity(): SaleInfoEntity {
        return SaleInfoEntity(
            buyLink = buyLink,
            country = country,
            isEbook = isEbook,
            saleability = saleability,
        )
    }
}