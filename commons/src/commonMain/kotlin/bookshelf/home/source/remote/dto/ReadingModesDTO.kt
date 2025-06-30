package bookshelf.home.source.remote.dto

import bookshelf.home.source.local.entity.ReadingModesEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReadingModesDTO(
    @SerialName("image")
    val image: Boolean? = null,
    @SerialName("text")
    val text: Boolean? = null,
) {
    fun toReadingModesEntity(): ReadingModesEntity {
        return ReadingModesEntity(
            image = image,
            text = text,
        )
    }
}