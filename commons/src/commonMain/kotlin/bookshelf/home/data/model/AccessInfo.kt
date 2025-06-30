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

import bookshelf.home.source.local.entity.AccessInfoEntity

data class AccessInfo(
    val accessViewStatus: String,
    val country: String,
    val embeddable: Boolean,
    val epub: Epub,
    val pdf: Pdf,
    val publicDomain: Boolean,
    val quoteSharingAllowed: Boolean,
    val textToSpeechPermission: String,
    val viewability: String,
    val webReaderLink: String,
)

fun AccessInfoEntity.toAccessInfo(): AccessInfo {
    return AccessInfo(
        accessViewStatus = accessViewStatus,
        country = country,
        embeddable = embeddable,
        epub = epubEntity.toEpub(),
        pdf = pdfEntity.toPdf(),
        publicDomain = publicDomain,
        quoteSharingAllowed = quoteSharingAllowed,
        textToSpeechPermission = textToSpeechPermission,
        viewability = viewability,
        webReaderLink = webReaderLink,
    )
}