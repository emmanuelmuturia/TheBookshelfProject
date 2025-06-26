package bookshelf.home.source.local.typeConverter

import androidx.room.TypeConverter
import bookshelf.home.source.local.entity.IndustryIdentifierEntity
import bookshelf.home.source.local.entity.ItemEntity
import kotlinx.serialization.json.Json

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