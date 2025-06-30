package bookshelf.home.data.model

import bookshelf.home.source.local.entity.ItemEntity

data class Item(
    val accessInfo: AccessInfo,
    val etag: String,
    val id: String,
    val kind: String,
    val saleInfo: SaleInfo,
    val searchInfo: SearchInfo,
    val selfLink: String,
    val volumeInfo: VolumeInfo,
)

fun ItemEntity.toItem(): Item {
    return Item(
        accessInfo = accessInfoEntity.toAccessInfo(),
        etag = etag,
        id = id,
        kind = kind,
        saleInfo = saleInfoEntity.toSaleInfo(),
        searchInfo = searchInfoEntity.toSearchInfo(),
        selfLink = selfLink,
        volumeInfo = volumeInfoEntity.toVolumeInfo(),
    )
}