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
package bookshelf.home.source.local.typeConverter

import androidx.room.TypeConverter
import bookshelf.home.source.local.entity.IndustryIdentifierEntity
import bookshelf.home.source.local.entity.ItemEntity
import kotlinx.serialization.json.Json

/**
 * This is the Home feature's [TypeConverter] for the Local Data Source...
 */

class BookshelfTypeConverters {
    private val json =
        Json {
            ignoreUnknownKeys = true
            isLenient = true
            encodeDefaults = true
            prettyPrint = true
        }

    @TypeConverter
    fun convertItemEntityToString(itemEntities: List<ItemEntity>): String {
        return json.encodeToString(value = itemEntities)
    }

    @TypeConverter
    fun convertStringToItemEntity(itemEntitiesString: String): List<ItemEntity> {
        return json.decodeFromString(string = itemEntitiesString)
    }

    @TypeConverter
    fun convertIndustryIdentifierEntityToString(industryIdentifierEntities: List<IndustryIdentifierEntity>): String {
        return json.encodeToString(value = industryIdentifierEntities)
    }

    @TypeConverter
    fun convertStringToIndustryIdentifierEntity(industryIdentifierEntitiesString: String): List<IndustryIdentifierEntity> {
        return json.decodeFromString(string = industryIdentifierEntitiesString)
    }
}