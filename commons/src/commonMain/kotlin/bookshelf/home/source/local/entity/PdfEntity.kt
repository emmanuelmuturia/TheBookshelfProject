package bookshelf.home.source.local.entity

import kotlinx.serialization.Serializable

@Serializable
data class PdfEntity(
    val acsTokenLink: String,
    val isAvailable: Boolean,
)