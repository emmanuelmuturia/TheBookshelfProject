package bookshelf.home.source.local.entity

import androidx.room.Embedded
import kotlinx.serialization.Serializable

@Serializable
data class AccessInfoEntity(
    val accessViewStatus: String,
    val country: String,
    val embeddable: Boolean,
    @Embedded(prefix = "epub")
    val epubEntity: EpubEntity,
    @Embedded(prefix = "pdf")
    val pdfEntity: PdfEntity,
    val publicDomain: Boolean,
    val quoteSharingAllowed: Boolean,
    val textToSpeechPermission: String,
    val viewability: String,
    val webReaderLink: String
)