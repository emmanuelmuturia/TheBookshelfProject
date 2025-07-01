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
package bookshelf.home.local.source.database

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import bookshelf.home.source.local.database.BookshelfDatabase

fun getBookshelfDatabase(context: Context): BookshelfDatabase {
    val databaseFile = context.getDatabasePath("bookshelf.db")
    return Room.databaseBuilder<BookshelfDatabase>(
        context = context.applicationContext,
        name = databaseFile.absolutePath,
    ).setDriver(driver = BundledSQLiteDriver())
        .build()
}