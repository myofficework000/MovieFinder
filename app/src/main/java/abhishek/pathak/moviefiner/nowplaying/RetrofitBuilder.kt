package abhishek.pathak.moviefiner.nowplaying

import abhishek.pathak.moviefiner.nowplaying.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    //add logging interceptor
    private lateinit var retrofit: Retrofit
    fun getRetrofit(): Retrofit {
        if(!RetrofitBuilder::retrofit.isInitialized){
            retrofit = Retrofit.Builder().addConverterFactory(
                GsonConverterFactory.create()
            ).baseUrl(BASE_URL)
                .build()
        }
        return retrofit
    }
}