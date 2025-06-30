package bookshelf.home.data.model

import bookshelf.home.source.local.entity.ItemEntity

data class Item(
    val accessInfo: AccessInfo? = null,
    val etag: String? = null,
    val id: String? = null,
    val kind: String? = null,
    val saleInfo: SaleInfo? = null,
    val searchInfo: SearchInfo? = null,
    val selfLink: String? = null,
    val volumeInfo: VolumeInfo? = null,
)

fun ItemEntity.toItem(): Item {
    return Item(
        accessInfo = accessInfoEntity?.toAccessInfo(),
        etag = etag,
        id = id,
        kind = kind,
        saleInfo = saleInfoEntity?.toSaleInfo(),
        searchInfo = searchInfoEntity?.toSearchInfo(),
        selfLink = selfLink,
        volumeInfo = volumeInfoEntity?.toVolumeInfo(),
    )
}