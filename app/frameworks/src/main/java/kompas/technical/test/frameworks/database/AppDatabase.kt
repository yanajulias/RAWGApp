package kompas.technical.test.frameworks.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kompas.technical.test.frameworks.database.converters.Converter
import kompas.technical.test.frameworks.http.model.local.FavoriteEntity

@TypeConverters(
    Converter::class
)
@Database(entities = [FavoriteEntity::class], exportSchema = false, version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoritesDao(): FavoritesDao
}