package bookshelf.home.source.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VolumeInfoDTO(
    @SerialName("allowAnonLogging")
    val allowAnonLogging: Boolean,
    @SerialName("authors")
    val authors: List<String>,
    @SerialName("canonicalVolumeLink")
    val canonicalVolumeLink: String,
    @SerialName("categories")
    val categories: List<String>,
    @SerialName("contentVersion")
    val contentVersion: String,
    @SerialName("description")
    val description: String,
    @SerialName("imageLinks")
    val imageLinksDTO: ImageLinksDTO,
    @SerialName("industryIdentifiers")
    val industryIdentifierDTOS: List<IndustryIdentifierDTO>,
    @SerialName("infoLink")
    val infoLink: String,
    @SerialName("language")
    val language: String,
    @SerialName("maturityRating")
    val maturityRating: String,
    @SerialName("pageCount")
    val pageCount: Int,
    @SerialName("panelizationSummary")
    val panelizationSummaryDTO: PanelizationSummaryDTO,
    @SerialName("previewLink")
    val previewLink: String,
    @SerialName("printType")
    val printType: String,
    @SerialName("publishedDate")
    val publishedDate: String,
    @SerialName("publisher")
    val publisher: String,
    @SerialName("readingModes")
    val readingModesDTO: ReadingModesDTO,
    @SerialName("subtitle")
    val subtitle: String,
    @SerialName("title")
    val title: String
)