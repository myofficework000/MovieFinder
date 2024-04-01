package abhishek.pathak.moviefiner.di

import abhishek.pathak.moviefiner.model.APIService
import abhishek.pathak.moviefiner.model.Repository
import abhishek.pathak.moviefiner.model.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Singleton
    @Provides
    fun provideAPIService():APIService{

        val baseURL = "https://api.themoviedb.org/3/"

        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        return Retrofit.Builder()
            .baseUrl(baseURL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(APIService::class.java)

    }

//    @Singleton
//    @Provides
//    fun provideHiltRepoImpl(apiService: APIService): Repository {
//        return HiltRepoImpl(apiService)
//    }
}