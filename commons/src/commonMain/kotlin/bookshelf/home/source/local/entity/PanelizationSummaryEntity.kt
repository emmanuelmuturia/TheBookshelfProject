package bookshelf.home.source.local.entity

import kotlinx.serialization.Serializable

@Serializable
data class PanelizationSummaryEntity(
    val containsEpubBubbles: Boolean? = null,
    val containsImageBubbles: Boolean? = null,
)