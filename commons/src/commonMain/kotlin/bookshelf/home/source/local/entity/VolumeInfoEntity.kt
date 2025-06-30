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
package bookshelf.home.source.local.entity

import androidx.room.Embedded
import kotlinx.serialization.Serializable

@Serializable
data class VolumeInfoEntity(
    val allowAnonLogging: Boolean? = null,
    val authors: List<String>? = null,
    val canonicalVolumeLink: String? = null,
    val categories: List<String>? = null,
    val contentVersion: String? = null,
    val description: String? = null,
    @Embedded(prefix = "imageLinks")
    val imageLinksEntity: ImageLinksEntity? = null,
    val industryIdentifierEntities: List<IndustryIdentifierEntity>? = null,
    val infoLink: String? = null,
    val language: String? = null,
    val maturityRating: String? = null,
    val pageCount: Int? = null,
    @Embedded(prefix = "panelizationSummary")
    val panelizationSummaryEntity: PanelizationSummaryEntity? = null,
    val previewLink: String? = null,
    val printType: String? = null,
    val publishedDate: String? = null,
    val publisher: String? = null,
    @Embedded(prefix = "readingModes")
    val readingModesEntity: ReadingModesEntity? = null,
    val subtitle: String? = null,
    val title: String? = null,
)