package kompas.technical.test.data_source.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kompas.technical.test.data_source.repository.GameRepository
import kompas.technical.test.data_source.repository.GameRepositoryImpl
import kompas.technical.test.frameworks.GameApiService
import kompas.technical.test.frameworks.database.FavoriteDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun bindGameRepository(
        gameApiService: GameApiService,
        favoriteDao: FavoriteDao
    ): GameRepository {
        return GameRepositoryImpl(gameApiService, favoriteDao)
    }
}