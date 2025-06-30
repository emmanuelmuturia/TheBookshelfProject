package bookshelf.home.source.remote.dto

import bookshelf.home.source.local.entity.PanelizationSummaryEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PanelizationSummaryDTO(
    @SerialName("containsEpubBubbles")
    val containsEpubBubbles: Boolean? = null,
    @SerialName("containsImageBubbles")
    val containsImageBubbles: Boolean? = null,
) {
    fun toPanelizationSummaryEntity(): PanelizationSummaryEntity {
        return PanelizationSummaryEntity(
            containsEpubBubbles = containsEpubBubbles,
            containsImageBubbles = containsImageBubbles,
        )
    }
}