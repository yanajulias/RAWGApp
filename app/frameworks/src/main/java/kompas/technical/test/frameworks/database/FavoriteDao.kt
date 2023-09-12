package kompas.technical.test.frameworks.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kompas.technical.test.frameworks.http.model.remote.GameDetailDto
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addToFavoriteList(favoriteEntity: GameDetailDto) : Long

    @Query("SELECT * FROM favorites_table")
    fun getFavoriteList(): Flow<List<GameDetailDto>>

    @Query("DELETE FROM favorites_table WHERE id = :id")
    fun removeFavoriteList(id: Int) : Int

    @Query("SELECT EXISTS(SELECT * FROM favorites_table WHERE id = :id)")
    fun isFavorite(id: Int): Boolean
}