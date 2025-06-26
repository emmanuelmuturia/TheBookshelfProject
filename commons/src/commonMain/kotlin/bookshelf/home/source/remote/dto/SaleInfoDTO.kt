package bookshelf.home.source.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SaleInfoDTO(
    @SerialName("buyLink")
    val buyLink: String,
    @SerialName("country")
    val country: String,
    @SerialName("isEbook")
    val isEbook: Boolean,
    @SerialName("saleability")
    val saleability: String,
)