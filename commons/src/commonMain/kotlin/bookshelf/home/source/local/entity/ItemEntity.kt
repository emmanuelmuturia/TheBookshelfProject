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
data class ItemEntity(
    @Embedded(prefix = "accessInfo")
    val accessInfoEntity: AccessInfoEntity? = null,
    val etag: String? = null,
    val id: String? = null,
    val kind: String? = null,
    @Embedded(prefix = "saleInfo")
    val saleInfoEntity: SaleInfoEntity? = null,
    @Embedded(prefix = "searchInfo")
    val searchInfoEntity: SearchInfoEntity? = null,
    val selfLink: String? = null,
    @Embedded(prefix = "volumeInfo")
    val volumeInfoEntity: VolumeInfoEntity? = null,
)