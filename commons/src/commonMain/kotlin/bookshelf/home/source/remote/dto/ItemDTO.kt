package bookshelf.home.source.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemDTO(
    @SerialName("accessInfo")
    val accessInfoDTO: AccessInfoDTO,
    @SerialName("etag")
    val etag: String,
    @SerialName("id")
    val id: String,
    @SerialName("kind")
    val kind: String,
    @SerialName("saleInfo")
    val saleInfoDTO: SaleInfoDTO,
    @SerialName("searchInfo")
    val searchInfoDTO: SearchInfoDTO,
    @SerialName("selfLink")
    val selfLink: String,
    @SerialName("volumeInfo")
    val volumeInfoDTO: VolumeInfoDTO,
)