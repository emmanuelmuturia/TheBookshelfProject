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
data class AccessInfoEntity(
    val accessViewStatus: String,
    val country: String,
    val embeddable: Boolean,
    @Embedded(prefix = "epub")
    val epubEntity: EpubEntity,
    @Embedded(prefix = "pdf")
    val pdfEntity: PdfEntity,
    val publicDomain: Boolean,
    val quoteSharingAllowed: Boolean,
    val textToSpeechPermission: String,
    val viewability: String,
    val webReaderLink: String,
)