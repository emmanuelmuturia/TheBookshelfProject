package bookshelf.home.data.model

import bookshelf.home.source.local.entity.PdfEntity

data class Pdf(
    val acsTokenLink: String,
    val isAvailable: Boolean,
)

fun PdfEntity.toPdf(): Pdf {
    return Pdf(
        acsTokenLink = acsTokenLink,
        isAvailable = isAvailable,
    )
}