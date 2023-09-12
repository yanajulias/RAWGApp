package kompas.technical.test.frameworks.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kompas.technical.test.frameworks.database.converters.Converter
import kompas.technical.test.frameworks.http.model.remote.GameDetailDto

@TypeConverters(
    Converter::class
)
@Database(entities = [GameDetailDto::class], exportSchema = false, version = 3)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoritesDao(): FavoriteDao

}