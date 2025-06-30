package bookshelf.home.data.model

import bookshelf.home.source.local.entity.VolumeInfoEntity

data class VolumeInfo(
    val allowAnonLogging: Boolean,
    val authors: List<String>,
    val canonicalVolumeLink: String,
    val categories: List<String>,
    val contentVersion: String,
    val description: String,
    val imageLinks: ImageLinks,
    val industryIdentifiers: List<IndustryIdentifier>,
    val infoLink: String,
    val language: String,
    val maturityRating: String,
    val pageCount: Int,
    val panelizationSummary: PanelizationSummary,
    val previewLink: String,
    val printType: String,
    val publishedDate: String,
    val publisher: String,
    val readingModes: ReadingModes,
    val subtitle: String,
    val title: String,
)

fun VolumeInfoEntity.toVolumeInfo(): VolumeInfo {
    return VolumeInfo(
        allowAnonLogging = allowAnonLogging,
        authors = authors,
        canonicalVolumeLink = canonicalVolumeLink,
        categories = categories,
        contentVersion = contentVersion,
        description = description,
        imageLinks = imageLinksEntity.toImageLinks(),
        industryIdentifiers = industryIdentifierEntities.map { it.toIndustryIdentifier() },
        infoLink = infoLink,
        language = language,
        maturityRating = maturityRating,
        pageCount = pageCount,
        panelizationSummary = panelizationSummaryEntity.toPanelizationSummary(),
        previewLink = previewLink,
        printType = printType,
        publishedDate = publishedDate,
        publisher = publisher,
        readingModes = readingModesEntity.toReadingModes(),
        subtitle = subtitle,
        title = title,
    )
}