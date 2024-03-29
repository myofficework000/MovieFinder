package abhishek.pathak.moviefiner.di

import abhishek.pathak.moviefiner.model.HiltRepoImpl
import abhishek.pathak.moviefiner.model.Repository
import abhishek.pathak.moviefiner.model.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindMyRepository(
        hiltRepoImpl: HiltRepoImpl
    ): Repository
}
