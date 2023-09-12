package kompas.technical.test.data_source.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kompas.technical.test.data_source.repository.GameRepository
import kompas.technical.test.data_source.usecase.local.FavoriteUseCaseImpl
import kompas.technical.test.data_source.usecase.remote.GameDetailUseCaseImpl
import kompas.technical.test.data_source.usecase.remote.GameSearchUseCaseImpl
import kompas.technical.test.data_source.usecase.remote.GameUseCaseImpl
import kompas.technical.test.domain.usecase.local.FavoriteUseCase
import kompas.technical.test.domain.usecase.remote.GameDetailUseCase
import kompas.technical.test.domain.usecase.remote.GameSearchUseCase
import kompas.technical.test.domain.usecase.remote.GameUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGameUseCase(gameRepository: GameRepository): GameUseCase = GameUseCaseImpl(gameRepository)

    @Provides
    @Singleton
    fun  provideGameDetailUseCase(gameRepository: GameRepository): GameDetailUseCase = GameDetailUseCaseImpl(gameRepository)

    @Provides
    @Singleton
    fun provideGameSearchUseCase(gameRepository: GameRepository): GameSearchUseCase = GameSearchUseCaseImpl(gameRepository)

    @Provides
    @Singleton
    fun provideFavoriteUseCase(gameRepository: GameRepository): FavoriteUseCase = FavoriteUseCaseImpl(gameRepository)
}