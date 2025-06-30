package bookshelf.home.source.remote.dto

import bookshelf.home.source.local.entity.ItemEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemDTO(
    @SerialName("accessInfo")
    val accessInfoDTO: AccessInfoDTO? = null,
    @SerialName("etag")
    val etag: String? = null,
    @SerialName("id")
    val id: String? = null,
    @SerialName("kind")
    val kind: String? = null,
    @SerialName("saleInfo")
    val saleInfoDTO: SaleInfoDTO? = null,
    @SerialName("searchInfo")
    val searchInfoDTO: SearchInfoDTO? = null,
    @SerialName("selfLink")
    val selfLink: String? = null,
    @SerialName("volumeInfo")
    val volumeInfoDTO: VolumeInfoDTO? = null,
) {
    fun toItemEntity(): ItemEntity {
        return ItemEntity(
            accessInfoEntity = accessInfoDTO?.toAccessInfoEntity(),
            etag = etag,
            id = id,
            kind = kind,
            saleInfoEntity = saleInfoDTO?.toSaleInfoEntity(),
            searchInfoEntity = searchInfoDTO?.toSearchInfoEntity(),
            selfLink = selfLink,
            volumeInfoEntity = volumeInfoDTO?.toVolumInfoEntity(),
        )
    }
}