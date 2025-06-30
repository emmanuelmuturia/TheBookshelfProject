package bookshelf.home.data.model

import bookshelf.home.source.local.entity.PdfEntity

data class Pdf(
    val acsTokenLink: String? = null,
    val isAvailable: Boolean? = null,
)

fun PdfEntity.toPdf(): Pdf {
    return Pdf(
        acsTokenLink = acsTokenLink,
        isAvailable = isAvailable,
    )
}