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

import bookshelf.home.source.local.entity.ItemEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemDTO(
    @SerialName("accessInfo")
    val accessInfoDTO: AccessInfoDTO? = null,
    @SerialName("etag")
    val etag: String? = null,
    @SerialName("id")
    val id: String? = null,
    @SerialName("kind")
    val kind: String? = null,
    @SerialName("saleInfo")
    val saleInfoDTO: SaleInfoDTO? = null,
    @SerialName("searchInfo")
    val searchInfoDTO: SearchInfoDTO? = null,
    @SerialName("selfLink")
    val selfLink: String? = null,
    @SerialName("volumeInfo")
    val volumeInfoDTO: VolumeInfoDTO? = null,
) {
    fun toItemEntity(): ItemEntity {
        return ItemEntity(
            accessInfoEntity = accessInfoDTO?.toAccessInfoEntity(),
            etag = etag,
            id = id,
            kind = kind,
            saleInfoEntity = saleInfoDTO?.toSaleInfoEntity(),
            searchInfoEntity = searchInfoDTO?.toSearchInfoEntity(),
            selfLink = selfLink,
            volumeInfoEntity = volumeInfoDTO?.toVolumInfoEntity(),
        )
    }
}