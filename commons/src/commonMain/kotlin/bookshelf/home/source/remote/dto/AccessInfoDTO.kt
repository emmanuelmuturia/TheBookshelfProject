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
package bookshelf.home.source.remote.dto

import bookshelf.home.source.local.entity.AccessInfoEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccessInfoDTO(
    @SerialName("accessViewStatus")
    val accessViewStatus: String,
    @SerialName("country")
    val country: String,
    @SerialName("embeddable")
    val embeddable: Boolean,
    @SerialName("epub")
    val epubDTO: EpubDTO,
    @SerialName("pdf")
    val pdfDTO: PdfDTO,
    @SerialName("publicDomain")
    val publicDomain: Boolean,
    @SerialName("quoteSharingAllowed")
    val quoteSharingAllowed: Boolean,
    @SerialName("textToSpeechPermission")
    val textToSpeechPermission: String,
    @SerialName("viewability")
    val viewability: String,
    @SerialName("webReaderLink")
    val webReaderLink: String,
) {
    fun toAccessInfoEntity(): AccessInfoEntity {
        return AccessInfoEntity(
            accessViewStatus = accessViewStatus,
            country = country,
            embeddable = embeddable,
            epubEntity = epubDTO.toEpubEntity(),
            pdfEntity = pdfDTO.toPdfEntity(),
            publicDomain = publicDomain,
            quoteSharingAllowed = quoteSharingAllowed,
            textToSpeechPermission = textToSpeechPermission,
            viewability = viewability,
            webReaderLink = webReaderLink,
        )
    }
}