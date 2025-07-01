/*
 * Copyright 2025 The Bookshelf Project
 *
 * Licenced under the Apache License, Version 2.0 (the "Licence");
 * you may not use this file except in compliance with the Licence.
 * You may obtain a copy of the Licence at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 */
package bookshelf.home.data.model

import bookshelf.home.source.local.entity.VolumeInfoEntity

data class VolumeInfo(
    val allowAnonLogging: Boolean? = null,
    val authors: List<String>? = null,
    val canonicalVolumeLink: String? = null,
    val categories: List<String>? = null,
    val contentVersion: String? = null,
    val description: String? = null,
    val imageLinks: ImageLinks? = null,
    val industryIdentifiers: List<IndustryIdentifier>? = null,
    val infoLink: String? = null,
    val language: String? = null,
    val maturityRating: String? = null,
    val pageCount: Int? = null,
    val panelizationSummary: PanelizationSummary? = null,
    val previewLink: String? = null,
    val printType: String? = null,
    val publishedDate: String? = null,
    val publisher: String? = null,
    val readingModes: ReadingModes? = null,
    val subtitle: String? = null,
    val title: String? = null,
)

fun VolumeInfoEntity.toVolumeInfo(): VolumeInfo {
    return VolumeInfo(
        allowAnonLogging = allowAnonLogging,
        authors = authors,
        canonicalVolumeLink = canonicalVolumeLink,
        categories = categories,
        contentVersion = contentVersion,
        description = description,
        imageLinks = imageLinksEntity?.toImageLinks(),
        industryIdentifiers = industryIdentifierEntities?.map { it.toIndustryIdentifier() },
        infoLink = infoLink,
        language = language,
        maturityRating = maturityRating,
        pageCount = pageCount,
        panelizationSummary = panelizationSummaryEntity?.toPanelizationSummary(),
        previewLink = previewLink,
        printType = printType,
        publishedDate = publishedDate,
        publisher = publisher,
        readingModes = readingModesEntity?.toReadingModes(),
        subtitle = subtitle,
        title = title,
    )
}