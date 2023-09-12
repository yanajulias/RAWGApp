package kompas.technical.test.frameworks.database.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import kompas.technical.test.frameworks.http.model.remote.DeveloperDto
import kompas.technical.test.frameworks.http.model.remote.GenreDto

class Converter {

    @TypeConverter
    fun fromGenresList(genreList: List<GenreDto>): String {
        return Gson().toJson(genreList)
    }

    @TypeConverter
    fun toGenresList(genreList: String?): List<GenreDto> {
        return Gson().fromJson(genreList, Array<GenreDto>::class.java).toList()
    }

    @TypeConverter
    fun fromDeveloperList(developerList: List<DeveloperDto>): String {
        return Gson().toJson(developerList)
    }

    @TypeConverter
    fun toDeveloperList(developerList: String?): List<DeveloperDto> {
        return Gson().fromJson(developerList, Array<DeveloperDto>::class.java).toList()
    }
}