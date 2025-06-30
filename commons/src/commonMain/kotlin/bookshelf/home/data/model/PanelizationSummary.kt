package bookshelf.home.data.model

import bookshelf.home.source.local.entity.PanelizationSummaryEntity

data class PanelizationSummary(
    val containsEpubBubbles: Boolean,
    val containsImageBubbles: Boolean,
)

fun PanelizationSummaryEntity.toPanelizationSummary(): PanelizationSummary {
    return PanelizationSummary(
        containsEpubBubbles = containsEpubBubbles,
        containsImageBubbles = containsImageBubbles,
    )
}