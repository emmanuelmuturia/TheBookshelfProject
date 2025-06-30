package bookshelf.home.data.model

import bookshelf.home.source.local.entity.AccessInfoEntity

data class AccessInfo(
    val accessViewStatus: String,
    val country: String,
    val embeddable: Boolean,
    val epub: Epub,
    val pdf: Pdf,
    val publicDomain: Boolean,
    val quoteSharingAllowed: Boolean,
    val textToSpeechPermission: String,
    val viewability: String,
    val webReaderLink: String,
)

fun AccessInfoEntity.toAccessInfo(): AccessInfo {
    return AccessInfo(
        accessViewStatus = accessViewStatus,
        country = country,
        embeddable = embeddable,
        epub = epubEntity.toEpub(),
        pdf = pdfEntity.toPdf(),
        publicDomain = publicDomain,
        quoteSharingAllowed = quoteSharingAllowed,
        textToSpeechPermission = textToSpeechPermission,
        viewability = viewability,
        webReaderLink = webReaderLink,
    )
}