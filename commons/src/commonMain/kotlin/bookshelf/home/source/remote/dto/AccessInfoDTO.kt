package bookshelf.home.source.remote.dto

import bookshelf.home.source.local.entity.AccessInfoEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccessInfoDTO(
    @SerialName("accessViewStatus")
    val accessViewStatus: String,
    @SerialName("country")
    val country: String,
    @SerialName("embeddable")
    val embeddable: Boolean,
    @SerialName("epub")
    val epubDTO: EpubDTO,
    @SerialName("pdf")
    val pdfDTO: PdfDTO,
    @SerialName("publicDomain")
    val publicDomain: Boolean,
    @SerialName("quoteSharingAllowed")
    val quoteSharingAllowed: Boolean,
    @SerialName("textToSpeechPermission")
    val textToSpeechPermission: String,
    @SerialName("viewability")
    val viewability: String,
    @SerialName("webReaderLink")
    val webReaderLink: String,
) {
    fun toAccessInfoEntity(): AccessInfoEntity {
        return AccessInfoEntity(
            accessViewStatus = accessViewStatus,
            country = country,
            embeddable = embeddable,
            epubEntity = epubDTO.toEpubEntity(),
            pdfEntity = pdfDTO.toPdfEntity(),
            publicDomain = publicDomain,
            quoteSharingAllowed = quoteSharingAllowed,
            textToSpeechPermission = textToSpeechPermission,
            viewability = viewability,
            webReaderLink = webReaderLink,
        )
    }
}