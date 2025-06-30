package bookshelf.home.source.remote.dto

import bookshelf.home.source.local.entity.PdfEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PdfDTO(
    @SerialName("acsTokenLink")
    val acsTokenLink: String? = null,
    @SerialName("isAvailable")
    val isAvailable: Boolean? = null,
) {
    fun toPdfEntity(): PdfEntity {
        return PdfEntity(
            acsTokenLink = acsTokenLink,
            isAvailable = isAvailable,
        )
    }
}