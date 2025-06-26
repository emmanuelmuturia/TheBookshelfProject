package bookshelf.home.source.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReadingModesDTO(
    @SerialName("image")
    val image: Boolean,
    @SerialName("text")
    val text: Boolean,
)