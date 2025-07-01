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

import bookshelf.home.source.local.entity.BooksEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BooksDTO(
    @SerialName("items")
    val itemDTOS: List<ItemDTO>? = null,
    @SerialName("kind")
    val kind: String? = null,
    @SerialName("totalItems")
    val totalItems: Int? = null,
) {
    fun toBooksEntity(): BooksEntity {
        return BooksEntity(
            itemEntities = itemDTOS?.map { it.toItemEntity() },
            kind = kind,
            totalItems = totalItems,
        )
    }
}