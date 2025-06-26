package bookshelf.home.source.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PanelizationSummaryDTO(
    @SerialName("containsEpubBubbles")
    val containsEpubBubbles: Boolean,
    @SerialName("containsImageBubbles")
    val containsImageBubbles: Boolean
)