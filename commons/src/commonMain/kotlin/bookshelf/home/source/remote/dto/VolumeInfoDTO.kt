package bookshelf.home.source.remote.dto

import bookshelf.home.source.local.entity.VolumeInfoEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VolumeInfoDTO(
    @SerialName("allowAnonLogging")
    val allowAnonLogging: Boolean? = null,
    @SerialName("authors")
    val authors: List<String>? = null,
    @SerialName("canonicalVolumeLink")
    val canonicalVolumeLink: String? = null,
    @SerialName("categories")
    val categories: List<String>? = null,
    @SerialName("contentVersion")
    val contentVersion: String? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("imageLinks")
    val imageLinksDTO: ImageLinksDTO? = null,
    @SerialName("industryIdentifiers")
    val industryIdentifierDTOS: List<IndustryIdentifierDTO>? = null,
    @SerialName("infoLink")
    val infoLink: String? = null,
    @SerialName("language")
    val language: String? = null,
    @SerialName("maturityRating")
    val maturityRating: String? = null,
    @SerialName("pageCount")
    val pageCount: Int? = null,
    @SerialName("panelizationSummary")
    val panelizationSummaryDTO: PanelizationSummaryDTO? = null,
    @SerialName("previewLink")
    val previewLink: String? = null,
    @SerialName("printType")
    val printType: String? = null,
    @SerialName("publishedDate")
    val publishedDate: String? = null,
    @SerialName("publisher")
    val publisher: String? = null,
    @SerialName("readingModes")
    val readingModesDTO: ReadingModesDTO? = null,
    @SerialName("subtitle")
    val subtitle: String? = null,
    @SerialName("title")
    val title: String? = null,
) {
    fun toVolumInfoEntity(): VolumeInfoEntity {
        return VolumeInfoEntity(
            allowAnonLogging = allowAnonLogging,
            authors = authors,
            canonicalVolumeLink = canonicalVolumeLink,
            categories = categories,
            contentVersion = contentVersion,
            description = description,
            imageLinksEntity = imageLinksDTO?.toImageLinksEntity(),
            industryIdentifierEntities = industryIdentifierDTOS?.map { it.toIndustryIdentifierEntity() },
            infoLink = infoLink,
            language = language,
            maturityRating = maturityRating,
            pageCount = pageCount,
            panelizationSummaryEntity = panelizationSummaryDTO?.toPanelizationSummaryEntity(),
            previewLink = previewLink,
            printType = printType,
            publishedDate = publishedDate,
            publisher = publisher,
            readingModesEntity = readingModesDTO?.toReadingModesEntity(),
            subtitle = subtitle,
            title = title,
        )
    }
}