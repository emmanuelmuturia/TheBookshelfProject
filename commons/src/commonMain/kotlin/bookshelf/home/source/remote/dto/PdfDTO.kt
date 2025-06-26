package bookshelf.home.source.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PdfDTO(
    @SerialName("acsTokenLink")
    val acsTokenLink: String,
    @SerialName("isAvailable")
    val isAvailable: Boolean
)