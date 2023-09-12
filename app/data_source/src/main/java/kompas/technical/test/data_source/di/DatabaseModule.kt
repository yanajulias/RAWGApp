package kompas.technical.test.data_source.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kompas.technical.test.frameworks.database.AppDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            name = "db_favorites"
        )
            .build()
    }

    @Provides
    @Singleton
    fun providesFavoritesDao(appDatabase: AppDatabase) = appDatabase.favoritesDao()
}
