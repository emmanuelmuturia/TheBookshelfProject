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

import bookshelf.home.source.local.entity.EpubEntity

data class Epub(
    val downloadLink: String? = null,
    val isAvailable: Boolean? = null,
)

fun EpubEntity.toEpub(): Epub {
    return Epub(
        downloadLink = downloadLink,
        isAvailable = isAvailable,
    )
}