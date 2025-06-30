package bookshelf.home.source.local.entity

import androidx.room.Embedded
import bookshelf.home.data.model.Item
import kotlinx.serialization.Serializable

@Serializable
data class ItemEntity(
    @Embedded(prefix = "accessInfo")
    val accessInfoEntity: AccessInfoEntity,
    val etag: String,
    val id: String,
    val kind: String,
    @Embedded(prefix = "saleInfo")
    val saleInfoEntity: SaleInfoEntity,
    @Embedded(prefix = "searchInfo")
    val searchInfoEntity: SearchInfoEntity,
    val selfLink: String,
    @Embedded(prefix = "volumeInfo")
    val volumeInfoEntity: VolumeInfoEntity,
)