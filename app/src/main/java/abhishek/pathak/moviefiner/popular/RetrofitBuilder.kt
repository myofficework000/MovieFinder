package abhishek.pathak.moviefiner.popular

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private lateinit var retrofit: Retrofit

    fun getRetrofit(): Retrofit{
        if(!RetrofitBuilder::retrofit.isInitialized){
            retrofit=Retrofit.Builder()
                .addConverterFactory(
                        GsonConverterFactory.create()
                        )
                .baseUrl(ConstantsPopular.BASE_URL)
                .build()
        }
        return retrofit
    }
}