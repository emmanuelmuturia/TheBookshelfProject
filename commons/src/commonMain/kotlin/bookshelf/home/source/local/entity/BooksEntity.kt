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

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Bookshelf")
data class BooksEntity(
    @PrimaryKey(autoGenerate = true)
    val bookshelfId: Int = 0,
    @ColumnInfo(name = "items")
    val itemEntities: List<ItemEntity>? = null,
    @ColumnInfo(name = "kind")
    val kind: String? = null,
    @ColumnInfo(name = "totalItems")
    val totalItems: Int? = null,
)