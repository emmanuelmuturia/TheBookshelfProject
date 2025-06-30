package bookshelf.home.source.local.entity

import androidx.room.Embedded
import bookshelf.home.data.model.Item
import kotlinx.serialization.Serializable

@Serializable
data class ItemEntity(
    @Embedded(prefix = "accessInfo")
    val accessInfoEntity: AccessInfoEntity? = null,
    val etag: String? = null,
    val id: String? = null,
    val kind: String? = null,
    @Embedded(prefix = "saleInfo")
    val saleInfoEntity: SaleInfoEntity? = null,
    @Embedded(prefix = "searchInfo")
    val searchInfoEntity: SearchInfoEntity? = null,
    val selfLink: String? = null,
    @Embedded(prefix = "volumeInfo")
    val volumeInfoEntity: VolumeInfoEntity? = null,
)