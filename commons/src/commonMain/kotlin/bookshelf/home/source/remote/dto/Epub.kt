package bookshelf.home.source.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Epub(
    @SerialName("downloadLink")
    val downloadLink: String,
    @SerialName("isAvailable")
    val isAvailable: Boolean
)