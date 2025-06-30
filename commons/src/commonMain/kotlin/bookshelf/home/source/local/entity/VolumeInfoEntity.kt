package bookshelf.home.source.local.entity

import androidx.room.Embedded
import kotlinx.serialization.Serializable

@Serializable
data class VolumeInfoEntity(
    val allowAnonLogging: Boolean? = null,
    val authors: List<String>? = null,
    val canonicalVolumeLink: String? = null,
    val categories: List<String>? = null,
    val contentVersion: String? = null,
    val description: String? = null,
    @Embedded(prefix = "imageLinks")
    val imageLinksEntity: ImageLinksEntity? = null,
    val industryIdentifierEntities: List<IndustryIdentifierEntity>? = null,
    val infoLink: String? = null,
    val language: String? = null,
    val maturityRating: String? = null,
    val pageCount: Int? = null,
    @Embedded(prefix = "panelizationSummary")
    val panelizationSummaryEntity: PanelizationSummaryEntity? = null,
    val previewLink: String? = null,
    val printType: String? = null,
    val publishedDate: String? = null,
    val publisher: String? = null,
    @Embedded(prefix = "readingModes")
    val readingModesEntity: ReadingModesEntity? = null,
    val subtitle: String? = null,
    val title: String? = null,
)