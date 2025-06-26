package bookshelf.home.source.local.entity

import androidx.room.Embedded
import kotlinx.serialization.Serializable

@Serializable
data class VolumeInfoEntity(
    val allowAnonLogging: Boolean,
    val authors: List<String>,
    val canonicalVolumeLink: String,
    val categories: List<String>,
    val contentVersion: String,
    val description: String,
    @Embedded(prefix = "imageLinks")
    val imageLinksEntity: ImageLinksEntity,
    val industryIdentifierEntities: List<IndustryIdentifierEntity>,
    val infoLink: String,
    val language: String,
    val maturityRating: String,
    val pageCount: Int,
    @Embedded(prefix = "panelizationSummary")
    val panelizationSummaryEntity: PanelizationSummaryEntity,
    val previewLink: String,
    val printType: String,
    val publishedDate: String,
    val publisher: String,
    @Embedded(prefix = "readingModes")
    val readingModesEntity: ReadingModesEntity,
    val subtitle: String,
    val title: String
)